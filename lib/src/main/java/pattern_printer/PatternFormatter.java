package pattern_printer;

import java.util.ArrayList;

public class PatternFormatter {
    public String getPatternString(String input, StitchGlossary stitches) {
        Stitch startingStitch;

        try {
            startingStitch = convertInputToStitches(input, stitches);
        } catch (UnknownStitchException e) {
            throw e;
        }

        return "";
    }

    private String convertStitchesToString(StitchNode startingStitch){

    }

    private Stitch convertInputToStitches(String input, StitchGlossary stitchTypes) {
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
