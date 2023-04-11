package pattern_printer;

import java.util.ArrayList;

public class PatternFormatter {
    public String getPatternString(String input, StitchGlossary stitches) {
        Stitch startingStitch;

        try {
            startingStitch = convertInputToSymbols(input, stitches);
        } catch (UnknownStitchException e) {
            throw e;
        }

        return "";
    }

    private Stitch convertInputToSymbols(String input, StitchGlossary stitches) {
        String[] spacedInput = input.trim().split("\\s+");
        Stitch headStitch = null;
        Stitch currentStitch = null;

        for(String s : spacedInput){
            if(headStitch == null){
                headStitch = stitches.getStitchByNameOrThrow(s);
                currentStitch = headStitch;
            }else{
                currentStitch.setNext(stitches.getStitchByNameOrThrow(s));
                currentStitch = currentStitch.getNext();
            }
        }

        return headStitch;
    }

}
