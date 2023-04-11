package pattern_printer.values;

public enum Constants{
    TURN("turn");
 
    public final String name;
 
    private Constants(String constantName) {
        this.name = constantName;
    }
}