package pattern_printer;

import org.junit.jupiter.api.Test;

public class PatternFormatterTest {
    private PatternFormatter getTestPatternFormatter(){
        return new PatternFormatter();
    }

    @Test
    public void getPatternStringTest(){
        String testString = "a b turn a";
        PatternFormatter patternFormatter = getTestPatternFormatter();
        StitchGlossary testPattern = new StitchGlossary();

        StitchType first = new StitchType("a", "!");
        StitchType second = new StitchType("b", "?");

        testPattern.addStitchOrThrow(first);
        testPattern.addStitchOrThrow(second);

        String result = patternFormatter.getPatternString(testString, testPattern);

        assert(result.equals(String.format("! ? turn \n! ", null)));
    }
    
}
