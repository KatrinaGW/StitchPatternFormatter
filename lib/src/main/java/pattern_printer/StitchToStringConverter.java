package pattern_printer;

import pattern_printer.values.Constants;

public class StitchToStringConverter {
    public static String convertStitchesToString(StitchNode startingStitch){
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
}
