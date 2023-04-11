package pattern_printer;
import java.util.HashMap;

public class StitchGlossary {
    private HashMap<String, Stitch> stitches;

    public StitchGlossary(){
        this.stitches = new HashMap<>();
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
