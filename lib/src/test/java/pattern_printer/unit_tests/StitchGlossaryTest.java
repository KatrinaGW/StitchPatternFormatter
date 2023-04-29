package pattern_printer.unit_tests;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import pattern_printer.StitchGlossary;
import pattern_printer.StitchType;
import pattern_printer.exceptions.StitchExistsException;

public class StitchGlossaryTest {
    private StitchGlossary getStitchGlossary(){
        return new StitchGlossary();
    }

    @Test
    public void addStitchOrThrowConstantName(){
        StitchGlossary stitchGlossary = getStitchGlossary();

        assertThrows(StitchExistsException.class, () -> {
            stitchGlossary.addStitchOrThrow(new StitchType("*", "*"));
        });
    }

    @Test
    public void turningStitchAdded(){
        String turnSymbol = "???";
        StitchGlossary stitchGlossary = new StitchGlossary(turnSymbol);

        assertThrows(StitchExistsException.class, () -> {
            stitchGlossary.addStitchOrThrow(new StitchType("turn", "*"));
        });

        StitchType result = stitchGlossary.getStitchByNameOrThrow("turn");

        assertTrue(result.getSymbol().equals(turnSymbol));
    }
}
