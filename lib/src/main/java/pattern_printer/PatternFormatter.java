package pattern_printer;

public class PatternFormatter {
    public String getPatternString(String input) {
        Stitch[][] stitchConversion;

        try {
            stitchConversion = convertInputToSymbols(input);
        } catch (UnknownStitchException e) {
            throw e;
        }

        return "";
    }

    private Stitch[][] convertInputToSymbols(String input) {
        String[] spacedInput = input.trim().split("\\s+");

        return null;
    }

}
