package pattern_printer;
public abstract class Stitch{
    private String symbol;
    private String name;
    private Stitch next;
    private Stitch previous;

    public Stitch(){
        symbol = "x";
        name = "defaultName";
    }

    public void setSymbol(String newSymbol){
        this.symbol = newSymbol;
    }

    public String getName(){
        return this.name;
    }

    public String getSymbol(){
        return this.symbol;
    }

    public void setNext(Stitch stitch){
        this.next = stitch;
    }

    public Stitch getNext(){
        return this.next;
    }

    public void setPrevious(Stitch stitch){
        this.previous = stitch;
    }

    public Stitch getPrevious(){
        return this.previous;
    }

}