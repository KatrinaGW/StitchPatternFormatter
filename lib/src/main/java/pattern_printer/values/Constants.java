package pattern_printer.values;

public enum Constants{
    TURN("turn"),
    REP_START_SYMBOL("*");
 
    public final String name;
 
    private Constants(String constantName) {
        this.name = constantName;
    }
}