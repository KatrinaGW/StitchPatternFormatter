package pattern_printer.presentation;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;

public class InstructionsPrinter extends Printer{
    public InstructionsPrinter(){
        String instructionsFilePath = new File("").getAbsolutePath().concat("/src/main/resources/Instructions.txt");
        filePath = Paths.get(instructionsFilePath);
        charset = StandardCharsets.UTF_8;

        setBufferedReader();
    }
    
}
