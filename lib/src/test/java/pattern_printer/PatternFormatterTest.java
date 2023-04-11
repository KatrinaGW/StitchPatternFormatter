package pattern_printer;

import java.util.regex.Pattern;

import org.checkerframework.checker.units.qual.g;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class PatternFormatterTest {
    private PatternFormatter getTestPatternFormatter(){
        return new PatternFormatter();
    }

    @Test
    public void getPatternStringTest(){
        String testString = "a b c";
        PatternFormatter patternFormatter = getTestPatternFormatter();
        StitchGlossary mockStitchGlossary = Mockito.mock(StitchGlossary.class);

        patternFormatter.getPatternString(testString, mockStitchGlossary);
    }
    
}
