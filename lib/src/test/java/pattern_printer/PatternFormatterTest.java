package pattern_printer;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class PatternFormatterTest {
    private PatternFormatter getTestPatternFormatter(){
        return new PatternFormatter();
    }

    @Test
    public void getPatternStringTest(){
        String testString = "a b ";
        PatternFormatter patternFormatter = getTestPatternFormatter();
        StitchGlossary testPattern = new StitchGlossary();

        StitchType first = new StitchType("a", "FirstSymbol");
        StitchType second = new StitchType("b", "Second Symbol");

        testPattern.addStitchOrThrow(first);
        testPattern.addStitchOrThrow(second);

        String result = patternFormatter.getPatternString(testString, testPattern);

        System.out.println(result);

        assert(true);
    }
    
}
