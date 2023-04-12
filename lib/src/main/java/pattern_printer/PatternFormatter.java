package pattern_printer;

import pattern_printer.exceptions.UnknownStitchException;
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

    private StitchNode convertInputToStitches(String input, StitchGlossary stitchTypes) {
        String[] spacedInput = input.trim().split("\\s+");
        StitchNode headStitch = null;
        StitchNode currentStitch = null;
        Stitch stitchType;

        for(String s : spacedInput){
            stitchType = stitchTypes.getStitchByNameOrThrow(s);
            if(headStitch == null){
                headStitch = new StitchNode(stitchType, null, null);
                currentStitch = headStitch;
            }else{
                currentStitch.setNext(new StitchNode(stitchType, null, currentStitch));
                currentStitch = currentStitch.getNext();
            }
        }

        return headStitch;
    }

}
