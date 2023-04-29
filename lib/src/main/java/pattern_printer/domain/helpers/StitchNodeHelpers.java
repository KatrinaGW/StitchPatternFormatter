package pattern_printer.domain.helpers;

import pattern_printer.domain.entities.StitchNode;

public class StitchNodeHelpers {

    public static StitchNode getHead(StitchNode currentStitch){
        while(currentStitch.getPrevious() != null){
            currentStitch = currentStitch.getPrevious();
        }

        return currentStitch;
    }
    
}
