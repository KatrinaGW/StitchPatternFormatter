package pattern_printer.unit_tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pattern_printer.domain.entities.StitchNode;
import pattern_printer.domain.entities.StitchType;
import pattern_printer.domain.providers.StitchMultiplier;

public class StitchMultiplierTest {
    private StitchNode head;
    private StitchNode second;
    private StitchNode third;
    private StitchNode tail;
    private StitchType headStitchType;
    private StitchType tailStitchType;
    private StitchType secondStitchType;
    private StitchType thirdStitchType;

    private void setMockSequence() {
        headStitchType = new StitchType("Lilo", ":)");
        tailStitchType = new StitchType("Stitch", ":(");
        secondStitchType = new StitchType("Dr", ":}");
        thirdStitchType = new StitchType("Frankenstein", ":{");

        head = new StitchNode(headStitchType, null, null);
        second = new StitchNode(secondStitchType, null, null);
        third = new StitchNode(thirdStitchType, null, null);
        tail = new StitchNode(tailStitchType, null, null);

        head.setNext(second);
        second.setPrevious(head);
        second.setNext(third);
        third.setPrevious(second);
        third.setNext(tail);
        tail.setPrevious(third);
    }

    @BeforeEach
    void initTestStitches() {
        setMockSequence();
    }

    @Test
    public void multiplyStitchSequenceTest(){
        StitchType previousHeadType = new StitchType("Previous Head", "?");
        StitchNode previousHead = new StitchNode(previousHeadType, null, null);
        StitchNode result = StitchMultiplier.multiplyStitchSequence(2, head, previousHead);

        assertEquals(tail.getStitchType(), result.getStitchType());

        StitchNode iterator = result.getPrevious();

        assertEquals(iterator.getStitchType(), thirdStitchType);
        iterator = iterator.getPrevious();
        assertEquals(iterator.getStitchType(), secondStitchType);
        iterator = iterator.getPrevious();
        assertEquals(iterator.getStitchType(), headStitchType);
        iterator = iterator.getPrevious();
        assertEquals(iterator.getStitchType(), tailStitchType);
        iterator = iterator.getPrevious();
        assertEquals(iterator.getStitchType(), thirdStitchType);
        iterator = iterator.getPrevious();
        assertEquals(iterator.getStitchType(), secondStitchType);
        iterator = iterator.getPrevious();
        assertEquals(iterator.getStitchType(), headStitchType);
        iterator = iterator.getPrevious();
        assertEquals(previousHead, iterator);
    }

    @Test
    public void multiplyStitchSequenceNullPreviousHeadTest(){
        StitchNode result = StitchMultiplier.multiplyStitchSequence(2, head, null);

        assertEquals(tail.getStitchType(), result.getStitchType());

        StitchNode iterator = result.getPrevious();

        assertEquals(iterator.getStitchType(), thirdStitchType);
        iterator = iterator.getPrevious();
        assertEquals(iterator.getStitchType(), secondStitchType);
        iterator = iterator.getPrevious();
        assertEquals(iterator.getStitchType(), headStitchType);
        iterator = iterator.getPrevious();
        assertEquals(iterator.getStitchType(), tailStitchType);
        iterator = iterator.getPrevious();
        assertEquals(iterator.getStitchType(), thirdStitchType);
        iterator = iterator.getPrevious();
        assertEquals(iterator.getStitchType(), secondStitchType);
        iterator = iterator.getPrevious();
        assertEquals(iterator.getStitchType(), headStitchType);
        iterator = iterator.getPrevious();
        assertNull(iterator);
    }
    
}
