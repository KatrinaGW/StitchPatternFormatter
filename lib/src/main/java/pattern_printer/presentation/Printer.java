package pattern_printer.presentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

public abstract class Printer {
    protected BufferedReader bufferedReader;
    protected Path filePath;
    protected Charset charset;

    protected void setBufferedReader(){
        try{
            this.bufferedReader = Files.newBufferedReader(filePath, charset);
        }catch(IOException e){
            System.out.format("I/O error: %s%n", e);
        }
    }

    public void print(){
        String line;

        if(bufferedReader == null){
            throw new IllegalArgumentException("Attempted to use a printer without"+
            "an initialized BufferedReader!");
        }

        try{
            line = bufferedReader.readLine();

            while(line != null){
                System.out.println(line);
                line = bufferedReader.readLine();
            }
        }catch(IOException e){
            System.out.format("I/O error: %s%n", e);
        }
        
    }
}
