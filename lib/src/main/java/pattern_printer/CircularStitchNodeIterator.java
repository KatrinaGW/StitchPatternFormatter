package pattern_printer;

public class CircularStitchNodeIterator {
    private StitchNode previous;
    private StitchNode next;
    private StitchNode head;
    private StitchNode tail;
    private int previousPos;
    private int lastIndex;

    public void placeIterator(int previousPos, StitchNode previous) {
        this.head = previous;
        this.previous = previous;
        this.previousPos = previousPos;
        this.next = head.getNext();
    }

    public void placeIteratorBeforeHead(int tailIndex, StitchNode head, StitchNode tail){
        this.head = head;
        this.previous = tail;
        this.tail = tail;
        this.previousPos = tailIndex;
        this.next = head;
        this.lastIndex = tailIndex;
    }

    public StitchNode next() {
        if (head == null) {
            throw new IllegalArgumentException("StitchNodeIterator has not been placed yet!");
        }

        if (next != null) {
            previous = next;
            next = next.getNext();
            previousPos++;
        } else {
            tail = previous;
            previous = head;
            next = head.getNext();
            lastIndex = previousPos;
            previousPos = 0;
        }

        return previous;
    }

    public StitchNode previous(){
        if (head == null) {
            throw new IllegalArgumentException("StitchNodeIterator has not been placed yet!");
        }

        if(previous == null){
            if(tail==null){
                findTail();
            }
            next = tail;
            previous = tail.getPrevious();
            previousPos = lastIndex-1;
        }else{
            next = previous;

            if(previous.getPrevious() == null){
                if(tail == null){
                    findTail();
                }
                previous = tail;
                previousPos = lastIndex;
            }else{
                previous = previous.getPrevious();
                previousPos--;
            }
        }

        return next;
    }

    private void findTail(){
        int index = previousPos;
        StitchNode iterator = previous;

        while(iterator.getNext()!=null){
            index++;
            iterator = iterator.getNext();
        }
        this.tail = iterator;
        this.lastIndex = index;
    }

    public int getPreviousPos() {
        return previousPos;
    }

}
