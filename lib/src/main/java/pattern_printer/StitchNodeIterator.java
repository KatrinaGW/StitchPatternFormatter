package pattern_printer;

public interface StitchNodeIterator {
    public void placeIterator(int previousPos, StitchNode previous);
    public void placeIteratorBeforeHead(StitchNode head);
    public StitchNode next();
    public StitchNode previous();
    public int getPreviousPos();
    public int getNextPos();
    public StitchNode getHead();
    public StitchNode getTail();
}
