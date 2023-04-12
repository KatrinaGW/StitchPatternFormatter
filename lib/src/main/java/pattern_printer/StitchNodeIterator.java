package pattern_printer;

public class StitchNodeIterator {
    private StitchNode previous;
    private StitchNode next;
    private StitchNode head;
    private int previousPos;

    public void placeIterator(int previousPos, StitchNode previous){
        this.head = previous;
        this.previous = previous;
        this.previousPos = previousPos;
        this.next = head.getNext();
    }

    public StitchNode nextCircular(){
        if(head == null){
            throw new IllegalArgumentException("StitchNodeIterator has not been placed yet!");
        }

        if(next!=null){
            previous = next;
            next = next.getNext();
            previousPos++;
        }else{
            previous = head;
            next = head.getNext();
            previousPos = 0;
        }

        return previous;
    }

    public int getPreviousPos(){
        return previousPos;
    }
    
}
