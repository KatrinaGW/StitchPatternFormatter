package pattern_printer;

public class StitchMultiplier {

    public static StitchNode multiplyStitchSequence(int multiplier, StitchNode startOfSequence, StitchNode previousHead){
        int counter = 0;
        CircularStitchNodeIterator circularStitchNodeIterator = new CircularStitchNodeIterator();

        circularStitchNodeIterator.placeIteratorBeforeHead(startOfSequence);

        StitchNode currentStitch = new StitchNode(circularStitchNodeIterator.next().getStitchType(), null, null);

        if(previousHead!=null){
            previousHead.setNext(currentStitch);
            currentStitch.setPrevious(previousHead);
        }

        if(circularStitchNodeIterator.getNextPos()==0){
            counter++;
        }

        while(counter < multiplier){
            currentStitch.setNext(new StitchNode(circularStitchNodeIterator.next().getStitchType(), null, currentStitch));
            currentStitch = currentStitch.getNext();
            if(circularStitchNodeIterator.getNextPos()==0){
                counter++;
            }
        }

        return currentStitch;
    }
}
