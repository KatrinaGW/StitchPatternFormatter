package pattern_printer.domain.entities.values;

public enum Constants{
    TURN("turn"),
    STITCH_MARKER("stitch marker"),
    REP_START_END_SYMBOL("*");
 
    public final String name;
 
    private Constants(String constantName) {
        this.name = constantName;
    }

    public static boolean containsName(String nameToCheck){
        boolean contains = false;
        int i = 0;

        while(i < values().length && !contains){
            contains = values()[i].name.equals(nameToCheck);
            i++;
        }

        return contains;
    }
}