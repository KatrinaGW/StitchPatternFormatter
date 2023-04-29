package pattern_printer;
import java.util.HashMap;

import pattern_printer.exceptions.StitchExistsException;
import pattern_printer.exceptions.UnknownStitchException;
import pattern_printer.values.Constants;

public class StitchGlossary {
    private HashMap<String, StitchType> stitches;

    public StitchGlossary(){
        this.stitches = new HashMap<>();
        this.stitches.put(Constants.TURN.name, new TurningStitch(Constants.TURN.name));
    }

    public StitchGlossary(String turningStitchSymbol){
        this.stitches = new HashMap<>();
        this.stitches.put(Constants.TURN.name, new TurningStitch(turningStitchSymbol));
    }

    public void addStitchOrThrow(StitchType stitch){
        if(stitches.containsKey(stitch.getName().toLowerCase()) || Constants.containsName(stitch.getName())){
            throw new StitchExistsException();
        }

        this.stitches.put(stitch.getName(), stitch);
    }

    public StitchType getStitchByNameOrThrow(String name){
        StitchType stitch; 
        if(stitches.containsKey(name.toLowerCase())){
            stitch = stitches.get(name);
        }else{
            throw new UnknownStitchException();
        }

        return stitch;
    }
}
