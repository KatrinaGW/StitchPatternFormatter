package pattern_printer.consolidated_tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pattern_printer.PatternFormatter;
import pattern_printer.StitchGlossary;
import pattern_printer.StitchToStringConverter;
import pattern_printer.StitchType;
import pattern_printer.StrInputToStitchesConverter;

public class InputToPrintedPatternTest {
    StitchType head;
    StitchType first;
    StitchType second;
    StitchType third;
    StitchType tail;
    StitchGlossary testPattern;

    @BeforeEach
    public void setStitches(){
        head = new StitchType("head", ".");
        first = new StitchType("a", "!");
        second = new StitchType("b", "?");
        third = new StitchType("c", "&");
        tail = new StitchType("tail", "|");

        testPattern = new StitchGlossary();

        testPattern.addStitchOrThrow(head);
        testPattern.addStitchOrThrow(first);
        testPattern.addStitchOrThrow(second);
        testPattern.addStitchOrThrow(third);
        testPattern.addStitchOrThrow(tail);
    }


    private PatternFormatter getTestPatternFormatter(){
        return new PatternFormatter(new StrInputToStitchesConverter(), new StitchToStringConverter());
    }

    @Test
    public void getPatternStringWithOneRepTest(){

        String testString = "head * a b * 2 tail";

        PatternFormatter patternFormatter = getTestPatternFormatter();

        String result = patternFormatter.getPatternString(testString, testPattern);

        assertTrue(result.equals(". ! ? ! ? | "));
    }

    @Test
    public void getPatternStringMultiRepsTest(){

        PatternFormatter patternFormatter = getTestPatternFormatter();

        String testString = "head b a c turn * a b * c a * 3 turn * 2 b b tail";

        String result = patternFormatter.getPatternString(testString, testPattern);

        assertTrue(result.equals(String.format(". ? ! & turn \n! ? & ! & ! & ! turn \n! ? & ! & ! & ! turn \n? ? | ", null)));
    }

    @Test
    public void getPatternStringEntireRepetition(){

        PatternFormatter patternFormatter = getTestPatternFormatter();

        String testString = "* head a b c tail turn * 2";

        String result = patternFormatter.getPatternString(testString, testPattern);

        assertTrue(result.equals(String.format(". ! ? & | turn \n. ! ? & | turn \n", null)));
    }

    @Test
    public void getPatternStringTest(){
        String testString = "a b turn a";
        PatternFormatter patternFormatter = getTestPatternFormatter();

        String result = patternFormatter.getPatternString(testString, testPattern);

        assert(result.equals(String.format("! ? turn \n! ", null)));
    }
    
}
