package pattern_printer.domain.providers;

import pattern_printer.domain.entities.StitchNode;
import pattern_printer.domain.entities.values.Constants;

public class StitchToStringConverter {
    public String convertStitchesToString(StitchNode startingStitch){
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
