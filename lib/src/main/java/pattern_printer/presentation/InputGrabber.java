package pattern_printer.presentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputGrabber {
    private BufferedReader bufferedReader;

    public InputGrabber(){
        this.bufferedReader = new BufferedReader(
            new InputStreamReader(System.in)
        );
    }

    public String getInput(){
        String input = null;

        try{
            input = bufferedReader.readLine();
        }catch(IOException e){
            System.out.println("An error occurred when reading the input");
        }

        return input;
    }
}
