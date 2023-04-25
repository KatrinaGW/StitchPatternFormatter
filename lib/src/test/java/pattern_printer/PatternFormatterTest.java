package pattern_printer;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PatternFormatterTest {
    private PatternFormatter getTestPatternFormatter(){
        return new PatternFormatter();
    }

    @Test
    public void getPatternStringWithOneRepTest(){
        StitchType head = new StitchType("head", ".");
        StitchType first = new StitchType("a", "!");
        StitchType second = new StitchType("b", "?");
        StitchType tail = new StitchType("tail", "|");

        String testString = "head * a b * 2 tail";

        PatternFormatter patternFormatter = getTestPatternFormatter();
        StitchGlossary testPattern = new StitchGlossary();

        testPattern.addStitchOrThrow(head);
        testPattern.addStitchOrThrow(first);
        testPattern.addStitchOrThrow(second);
        testPattern.addStitchOrThrow(tail);

        String result = patternFormatter.getPatternString(testString, testPattern);

        assertTrue(result.equals(". ! ? ! ? | "));

        assertTrue(true);
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
