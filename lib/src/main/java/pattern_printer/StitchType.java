package pattern_printer;


public class StitchType implements Stitch{
    private String name;
    private String symbol;

    public StitchType(String name, String symbol){
        this.name = name;
        this.symbol = symbol;
    }

    public String getName(){
        return name;
    }

    public String getSymbol(){
        return symbol;
    }

    public void setName(String newName){
        this.name = newName;
    }

    public void setSymbol(String newSymbol){
        this.symbol = newSymbol;
    }
    
}
