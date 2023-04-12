package pattern_printer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CircularStitchNodeIteratorTest {
    private StitchNode head;
    private StitchNode second;
    private StitchNode third;
    private StitchNode tail;
    private StitchType stitchType;
    private CircularStitchNodeIterator testStitchNodeIterator;

    private void setMockSequence() {
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
    void initTestStitches() {
        setMockSequence();
        testStitchNodeIterator = new CircularStitchNodeIterator();
    }

    @Test
    public void nextThrowsTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            testStitchNodeIterator.next();
        });
    }

    @Test
    public void nextBasicTest() {
        testStitchNodeIterator.placeIterator(0, head);

        assertEquals(second, testStitchNodeIterator.next());
        assertEquals(1, testStitchNodeIterator.getPreviousPos());
        assertEquals(2, testStitchNodeIterator.getNextPos());
    }

    @Test
    public void nextWrapTest() {
        testStitchNodeIterator.placeIterator(0, head);
        testStitchNodeIterator.next();
        testStitchNodeIterator.next();
        assertEquals(tail, testStitchNodeIterator.next());
        assertEquals(3, testStitchNodeIterator.getPreviousPos());
        assertEquals(0, testStitchNodeIterator.getNextPos());
        assertEquals(head, testStitchNodeIterator.next());
        assertEquals(0, testStitchNodeIterator.getPreviousPos());
        assertEquals(1, testStitchNodeIterator.getNextPos());
    }

    @Test
    public void previousBasicTest(){
        testStitchNodeIterator.placeIterator(0, head);
        assertEquals(head, testStitchNodeIterator.previous());
        assertEquals(3, testStitchNodeIterator.getPreviousPos());
        assertEquals(0, testStitchNodeIterator.getNextPos());
    }

    @Test
    public void previousWrapsTest(){
        testStitchNodeIterator.placeIterator(0, head);
        testStitchNodeIterator.previous();
        assertEquals(tail, testStitchNodeIterator.previous());
        assertEquals(2, testStitchNodeIterator.getPreviousPos());
        assertEquals(3, testStitchNodeIterator.getNextPos());
    }
}
