package pattern_printer;

import java.util.regex.Pattern;

import org.checkerframework.checker.units.qual.g;
import org.junit.Test;

public class PatternFormatterTest {
    private PatternFormatter getTestPatternFormatter(){
        return new PatternFormatter();
    }

    @Test
    public void getPatternStringTest(){
        String testString = "a b c";
        PatternFormatter patternFormatter = getTestPatternFormatter();

        patternFormatter.getPatternString(testString);
    }
    
}
