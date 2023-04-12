package pattern_printer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StitchNodeIteratorTest {
    private StitchNode head;
    private StitchNode second;
    private StitchNode third;
    private StitchNode tail;
    private StitchType stitchType;

    private void setMockSequence(){
        stitchType = new StitchType("Lilo", ":)");
        head = new StitchNode(stitchType, null, null);
        second = new StitchNode(stitchType, null, null);
        third = new StitchNode(stitchType, null, null);
        tail = new StitchNode(stitchType, null, null);

        head.setNext(second);
        second.setPrevious(head);
        second.setNext(third);
        third.setPrevious(second);
        third.setNext(tail);
        tail.setPrevious(third);
    }

    @BeforeEach
    void initTestStitches(){
        setMockSequence();
    }

    @Test
    public void getNextCircularThrowsTest(){
        StitchNodeIterator testStitchNodeIterator = new StitchNodeIterator();

        assertThrows(IllegalArgumentException.class, () -> {
            testStitchNodeIterator.nextCircular();
        });
    }

    @Test
    public void getNextCircularBasicTest(){
        StitchNodeIterator testStitchNodeIterator = new StitchNodeIterator();

        testStitchNodeIterator.placeIterator(0, head);

        assertEquals(second, testStitchNodeIterator.nextCircular());
        assertEquals(1, testStitchNodeIterator.getPreviousPos());
    }

    @Test
    public void getNextCircularWrapTest(){
        StitchNodeIterator testStitchNodeIterator = new StitchNodeIterator();

        testStitchNodeIterator.placeIterator(0, head);
        testStitchNodeIterator.nextCircular();
        testStitchNodeIterator.nextCircular();
        testStitchNodeIterator.nextCircular();
        assertEquals(head, testStitchNodeIterator.nextCircular());
        assertEquals(0, testStitchNodeIterator.getPreviousPos());
    }
    
}
