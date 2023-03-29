package pattern_printer;
import java.util.HashMap;

public class Stitches {
    private HashMap<String, Stitch> stitches;

    public Stitches(){
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
