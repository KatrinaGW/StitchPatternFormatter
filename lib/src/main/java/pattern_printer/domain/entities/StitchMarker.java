package pattern_printer.domain.entities;

import pattern_printer.domain.entities.exceptions.EndOfPatternException;
import pattern_printer.domain.entities.values.Constants;

public class StitchMarker extends StitchType implements StitchNodeIterator{
    private StitchNode previous;
    private StitchNode next;
    private int previousPos;
    private int nextPos;
    private StitchNode head;
    private StitchNode tail;

    public StitchMarker(String symbol) {
        super(Constants.STITCH_MARKER.name, symbol);
    }

    @Override
    public void placeIterator(int previousPos, StitchNode previous) {
        this.previous = previous;
        this.previousPos = previousPos;

        setNext();
    }

    @Override
    public void placeIteratorBeforeHead(StitchNode head) {
        this.next = head;
        this.nextPos = 0;
        this.previousPos = -1;
        this.previous = null;
    }

    private void setNext(){
        this.next = previous.getNext();

        if(next == null){
            this.tail = this.previous;
            this.nextPos = -1;
        }else{
            this.nextPos = previousPos+1;
        }
    }

    private void setPrevious(){
        this.previous = next.getPrevious();

        if(previous == null){
            this.head = this.next;
            this.previousPos = -1;
        }else{
            this.previousPos = this.nextPos -1;
        }
    }

    @Override
    public StitchNode next() {
        if(this.nextPos == -1){
            throw new EndOfPatternException();
        }

        this.previous = this.next;
        this.previousPos++;

        setNext();

        return this.previous;
    }

    @Override
    public StitchNode previous() {
        if(this.previousPos == -1){
            throw new EndOfPatternException();
        }

        this.next = this.previous;
        this.nextPos--;

        setPrevious();

        return this.next;
    }

    @Override
    public int getPreviousPos() {
        return this.previousPos;
    }

    @Override
    public int getNextPos() {
        return this.nextPos;
    }

    private void findHead(){
        StitchNode iterator = this.next;

        while(iterator.getNext() != null){
            iterator = iterator.getNext();
        }

        this.head = iterator;
    }

    private void findTail(){
        StitchNode iterator = this.previous;

        while(iterator.getPrevious()!=null){
            iterator = iterator.getPrevious();
        }

        this.tail = iterator;
    }

    @Override
    public StitchNode getHead() {
        if(this.head == null){
            findHead();
        }

        return this.head;
    }

    @Override
    public StitchNode getTail() {
        if(this.tail == null){
            findTail();
        }

        return this.tail;
    }
    
}
