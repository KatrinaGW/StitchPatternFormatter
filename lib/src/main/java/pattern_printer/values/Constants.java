package pattern_printer.values;

public enum Constants{
    TURN("turn"),
    STITCH_MARKER("stitch marker"),
    REP_START_END_SYMBOL("*");
 
    public final String name;
 
    private Constants(String constantName) {
        this.name = constantName;
    }
}