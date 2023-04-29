package pattern_printer.unit_tests;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import pattern_printer.PatternFormatter;
import pattern_printer.StitchGlossary;
import pattern_printer.StitchNode;
import pattern_printer.StitchToStringConverter;
import pattern_printer.StrInputToStitchesConverter;
import pattern_printer.exceptions.UnknownStitchException;

public class PatternFormatterTest {
    private StitchToStringConverter mockStitchToStringConverter;
    private StrInputToStitchesConverter mockStrInputToStitchesConverter;

    private PatternFormatter getPatternFormatter(){
        return new PatternFormatter(mockStrInputToStitchesConverter, mockStitchToStringConverter);
    }

    @BeforeEach
    public void setMocks(){
        mockStitchToStringConverter = Mockito.mock(StitchToStringConverter.class);
        mockStrInputToStitchesConverter = Mockito.mock(StrInputToStitchesConverter.class);
    }

    @Test
    public void getPatternStringTest(){
        String testInput = "a b c";
        String testOutput = "1 2 3";
        StitchGlossary mockStitches = Mockito.mock(StitchGlossary.class);
        StitchNode mockStitchNode = Mockito.mock(StitchNode.class);

        when(mockStrInputToStitchesConverter.convertInputToStitches(testInput, mockStitches))
        .thenReturn(mockStitchNode);
        when(mockStitchToStringConverter.convertStitchesToString(mockStitchNode)).thenReturn(testOutput);

        PatternFormatter patternFormatter = getPatternFormatter();

        String result = patternFormatter.getPatternString(testInput, mockStitches);

        verify(mockStrInputToStitchesConverter, times(1)).convertInputToStitches(testInput, mockStitches);

        verify(mockStitchToStringConverter, times(1)).convertStitchesToString(mockStitchNode);

        assertTrue(result.equals(testOutput));
    }

    @Test
    public void unknownStitchExceptionThrownTest(){
        String testInput = "a b c";
        StitchGlossary mockStitches = Mockito.mock(StitchGlossary.class);

        when(mockStrInputToStitchesConverter.convertInputToStitches(testInput, mockStitches))
        .thenThrow(UnknownStitchException.class);

        assertThrows(UnknownStitchException.class, () -> {
            getPatternFormatter().getPatternString(testInput, mockStitches);
        });

        verify(mockStrInputToStitchesConverter, times(1)).convertInputToStitches(testInput, mockStitches);
        verify(mockStitchToStringConverter, times(0)).convertStitchesToString(any(StitchNode.class));
    }
    
}
