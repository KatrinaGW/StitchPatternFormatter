package pattern_printer.application;

import pattern_printer.domain.entities.StitchGlossary;
import pattern_printer.domain.providers.PatternFormatter;
import pattern_printer.domain.providers.StitchToStringConverter;
import pattern_printer.domain.providers.StrInputToStitchesConverter;

public class ApplicationContext {
    private static ApplicationContext INSTANCE;
    private PatternFormatter patternFormatter;
    private StitchGlossary stitchGlossary;

    private ApplicationContext(String turnSymbole){
        patternFormatter = new PatternFormatter(new StrInputToStitchesConverter(), new StitchToStringConverter());
        stitchGlossary = new StitchGlossary(turnSymbole);
    }

    private ApplicationContext(){
        patternFormatter = new PatternFormatter(new StrInputToStitchesConverter(), new StitchToStringConverter());
        stitchGlossary = new StitchGlossary();
    }

    public static ApplicationContext getInstance(String turnSymbol){
        if(INSTANCE == null){
            INSTANCE = new ApplicationContext(turnSymbol);
        }

        return INSTANCE;
    }

    public static ApplicationContext getInstance(){
        if(INSTANCE == null){
            INSTANCE = new ApplicationContext();
        }

        return INSTANCE;
    }

    public PatternFormatter getPatternFormatter(){
        return this.patternFormatter;
    }

    public StitchGlossary getStitchGlossary(){
        return this.stitchGlossary;
    }
    
}
