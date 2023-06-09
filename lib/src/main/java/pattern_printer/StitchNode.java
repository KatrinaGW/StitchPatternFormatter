package pattern_printer;

public class StitchNode implements Stitch{
    private StitchType stitchType;
    private StitchNode next;
    private StitchNode previous;

    public StitchNode(StitchType baseType, StitchNode next, StitchNode previous){
        this.stitchType = baseType;
        this.next = next;
        this.previous = previous;
    }
    
    public StitchType getStitchType(){
        return stitchType;
    }

    public String getName(){
        return stitchType.getName();
    }

    public String getSymbol(){
        return stitchType.getSymbol();
    }

    public void setNext(StitchNode stitch){
        this.next = stitch;
    }

    public StitchNode getNext(){
        return this.next;
    }

    public void setPrevious(StitchNode stitch){
        this.previous = stitch;
    }

    public StitchNode getPrevious(){
        return this.previous;
    }
}