package pattern_printer;
public abstract class Stitch{
    private String symbol;
    private String name;

    public void setSymbol(String newSymbol){
        this.symbol = newSymbol;
    }

    public String getName(){
        return this.name;
    }

    public String getSymbol(){
        return this.symbol;
    }

}