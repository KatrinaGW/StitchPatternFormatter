package pattern_printer;

import pattern_printer.exceptions.UnknownStitchException;

public class PatternFormatter {
    private StrInputToStitchesConverter strInputToStitchesConverter;

    public PatternFormatter(StrInputToStitchesConverter strInputToStitchesConverter){
        this.strInputToStitchesConverter = strInputToStitchesConverter;
    }

    public String getPatternString(String input, StitchGlossary stitches) {
        StitchNode startingStitch;

        try {
            startingStitch = strInputToStitchesConverter.convertInputToStitches(input, stitches);
        } catch (UnknownStitchException e) {
            throw e;
        }

        return StitchToStringConverter.convertStitchesToString(startingStitch);
    }

}
