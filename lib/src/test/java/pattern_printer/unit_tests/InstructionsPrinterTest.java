package pattern_printer.unit_tests;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

import pattern_printer.presentation.InstructionsPrinter;

public class InstructionsPrinterTest {
    @Test
    public void printInstructions(){
        InstructionsPrinter instructionsPrinter = new InstructionsPrinter();
        assertDoesNotThrow(() -> {
            instructionsPrinter.print();
        });
    }
}
