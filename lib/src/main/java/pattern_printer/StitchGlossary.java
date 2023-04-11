package pattern_printer;
import java.util.HashMap;

import pattern_printer.values.Constants;

public class StitchGlossary {
    private HashMap<String, Stitch> stitches;

    public StitchGlossary(){
        this.stitches = new HashMap<>();
        this.stitches.put(Constants.TURN.name, new TurningStitch());
    }

    public void addStitchOrThrow(Stitch stitch){
        if(stitches.containsKey(stitch.getName().toLowerCase())){
            throw new StitchExistsException();
        }

        this.stitches.put(stitch.getName(), stitch);
    }

    public Stitch getStitchByNameOrThrow(String name){
        Stitch stitch; 
        if(stitches.containsKey(name.toLowerCase())){
            stitch = stitches.get(name);
        }else{
            throw new UnknownStitchException();
        }

        return stitch;
    }
}
