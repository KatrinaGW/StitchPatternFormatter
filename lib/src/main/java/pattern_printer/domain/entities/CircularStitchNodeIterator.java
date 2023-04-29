package pattern_printer.domain.entities;

public class CircularStitchNodeIterator implements StitchNodeIterator{
    private StitchNode previous;
    private StitchNode next;
    private StitchNode head;
    private StitchNode tail;
    private int previousPos;
    private int nextPos;
    private int lastIndex;

    public void placeIterator(int previousPos, StitchNode previous) {
        this.head = previous;
        this.previous = previous;
        this.previousPos = previousPos;
        this.next = head.getNext();
    }

    public void placeIteratorBeforeHead(StitchNode head){
        this.head = head;
        this.next = head;
        this.previousPos = -1;
        this.nextPos = 0;
        this.next = head;
    }

    public void placeIteratorBeforeHeadWithTail(int tailIndex, StitchNode head, StitchNode tail){
        this.head = head;
        this.previous = tail;
        this.tail = tail;
        this.previousPos = tailIndex;
        this.next = head;
        this.lastIndex = tailIndex;
        this.nextPos = 0;
    }

    public StitchNode next() {
        if (head == null) {
            throw new IllegalArgumentException("StitchNodeIterator has not been placed yet!");
        }

        if (next != null) {
            previous = next;
            next = next.getNext();
            previousPos++;

            if(next==null){
                nextPos = 0;
            }else{
                nextPos=previousPos+1;
            }

        } else {
            tail = previous;
            previous = head;
            next = head.getNext();
            lastIndex = previousPos;
            previousPos = 0;
            nextPos = 1;
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
            nextPos = lastIndex;
            previousPos = lastIndex-1;
        }else{
            next = previous;

            if(previous.getPrevious() == null){
                if(tail == null){
                    findTail();
                }
                previous = tail;
                nextPos = 0;
                previousPos = lastIndex;
            }else{
                previous = previous.getPrevious();
                nextPos = previousPos;
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

    private void findHead(){
        if(head!=null){
            StitchNode iterator = previous;

            while(iterator.getPrevious()!=null){
                iterator=iterator.getPrevious();
            }

            head = iterator;
        }
    }

    public StitchNode getHead(){
        if(head == null){
            findHead();
        }
        return head;
    }

    public StitchNode getTail(){
        if(tail == null){
            findTail();
        }
        return tail;
    }

    public int getPreviousPos() {
        return previousPos;
    }

    public int getNextPos(){
        return nextPos;
    }

}
