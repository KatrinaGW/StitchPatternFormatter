package pattern_printer.domain.entities;

import pattern_printer.domain.entities.values.Constants;

public class TurningStitch extends StitchType{
    public TurningStitch(String symbol){
        super(Constants.TURN.name, symbol);
    }
}
