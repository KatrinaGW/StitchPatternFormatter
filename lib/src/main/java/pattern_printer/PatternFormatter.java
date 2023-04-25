package pattern_printer;

import java.util.Stack;
import java.util.regex.Pattern;

import org.apache.commons.math3.util.Pair;

import pattern_printer.exceptions.UnknownStitchException;
import pattern_printer.helpers.StitchNodeHelpers;
import pattern_printer.values.Constants;

public class PatternFormatter {
    public String getPatternString(String input, StitchGlossary stitches) {
        StitchNode startingStitch;

        try {
            startingStitch = convertInputToStitches(input, stitches);
        } catch (UnknownStitchException e) {
            throw e;
        }

        return convertStitchesToString(startingStitch);
    }

    private String convertStitchesToString(StitchNode startingStitch){
        String strPattern = "";

        StitchNode currentStitch = startingStitch;

        while(currentStitch!=null){
            strPattern = String.format("%s%s ", strPattern, currentStitch.getSymbol());
            if(currentStitch.getName().equals(Constants.TURN.name)){
                strPattern = String.format("%s\n", strPattern);
            }
            currentStitch = currentStitch.getNext();
        }

        return strPattern;
    }

    private boolean isDigit(String strNum) {
        Pattern pattern = Pattern.compile("^[0-9]*$");

        if (strNum == null) {
            return false; 
        }
        return pattern.matcher(strNum).matches();
    }

    private Pair<StitchNode, Integer> handleRepetition(StitchNode previousHead, String[] spacedInput, int currentIndex, 
    StitchGlossary stitchTypes){
        int numInProgressReps = 1;
        Stack<StitchNode> repStarts = new Stack<>();
        Stack<StitchNode> previousHeads = new Stack<>();
        StitchNode currentRepStitch = null;
        String s;
        StitchType stitchType;

        previousHeads.push(previousHead);

        while(numInProgressReps>0){
            s = spacedInput[currentIndex];

            if(s.equals(Constants.REP_START_END_SYMBOL.name)){
                if(isDigit(spacedInput[currentIndex+1])){
                    if(numInProgressReps<1){
                        throw new IllegalArgumentException("End of repetition symbol received when no repetition"+
                        " was in progress");
                    }

                    numInProgressReps--;

                    currentRepStitch = StitchMultiplier.multiplyStitchSequence(Integer.parseInt(spacedInput[currentIndex+1]), 
                    repStarts.pop(), previousHeads.pop());

                    currentIndex+=1;

                }else{
                    previousHeads.push(currentRepStitch);
                    currentRepStitch = null;
                    numInProgressReps++;
                }

                
            }else{
                stitchType = stitchTypes.getStitchByNameOrThrow(s);

                if(currentRepStitch == null){
                    currentRepStitch = new StitchNode(stitchType, null, null);
                    repStarts.push(currentRepStitch);
                }else{
                    currentRepStitch.setNext(new StitchNode(stitchType, null, currentRepStitch));
                    currentRepStitch = currentRepStitch.getNext();
                }
            }
            
            currentIndex++;

            if(currentIndex>spacedInput.length){
                throw new IllegalArgumentException("Repetition not properly terminated!");
            }
        }

        return new Pair<StitchNode, Integer>(currentRepStitch, currentIndex);
    }

    private StitchNode convertInputToStitches(String input, StitchGlossary stitchTypes) {
        String[] spacedInput = input.trim().split("\\s+");
        StitchNode headStitch = null;
        StitchNode currentStitch = null;
        StitchType stitchType;
        int i = 0;
        String s;

        while(i<spacedInput.length){
            s = spacedInput[i];
            if(s.equals(Constants.REP_START_END_SYMBOL.name)){
                Pair<StitchNode, Integer> repetitionResult = handleRepetition(currentStitch, spacedInput, i + 1, stitchTypes);
                currentStitch = repetitionResult.getFirst();
                i = repetitionResult.getSecond(); 

                if(headStitch == null){
                    headStitch = StitchNodeHelpers.getHead(currentStitch);
                }
            }else{
                stitchType = stitchTypes.getStitchByNameOrThrow(s);
                if(headStitch == null){
                    headStitch = new StitchNode(stitchType, null, null);
                    currentStitch = headStitch;
                }else{
                    currentStitch.setNext(new StitchNode(stitchType, null, currentStitch));
                    currentStitch = currentStitch.getNext();
                }
                i++;
            }
        }

        return headStitch;
    }

}
