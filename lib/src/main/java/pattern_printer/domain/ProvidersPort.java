package pattern_printer.domain;

import pattern_printer.domain.providers.PatternFormatter;
import pattern_printer.domain.providers.StitchToStringConverter;
import pattern_printer.domain.providers.StrInputToStitchesConverter;

public class ProvidersPort {
    private static ProvidersPort INSTANCE;
    private PatternFormatter patternFormatter;

    private ProvidersPort(){
        this.patternFormatter = new PatternFormatter(new StrInputToStitchesConverter(), new StitchToStringConverter());
    }

    public static ProvidersPort getInstance(){
        if(INSTANCE == null){
            INSTANCE = new ProvidersPort();
        }

        return INSTANCE;
    }
    
}
