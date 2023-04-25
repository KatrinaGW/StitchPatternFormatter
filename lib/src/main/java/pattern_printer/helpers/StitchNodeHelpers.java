package pattern_printer.helpers;

import pattern_printer.StitchNode;

public class StitchNodeHelpers {

    public static StitchNode getHead(StitchNode currentStitch){
        while(currentStitch.getPrevious() != null){
            currentStitch = currentStitch.getPrevious();
        }

        return currentStitch;
    }
    
}
