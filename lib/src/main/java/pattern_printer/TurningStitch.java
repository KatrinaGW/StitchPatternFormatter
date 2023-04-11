package pattern_printer;

import pattern_printer.values.Constants;

public class TurningStitch implements Stitch{
    public String getName(){
        return Constants.TURN.name();
    }

    public String getSymbol(){
        return "\n";
    }
}
