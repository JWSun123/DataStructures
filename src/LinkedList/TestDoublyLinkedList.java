package LinkedList;

import org.junit.Assert;
import org.junit.Test;

public class TestDoublyLinkedList {
    DoublyLinkedList target = new DoublyLinkedList();

    @Test
    public void testAddToFront(){
        target.addToFront(11);
        Assert.assertEquals(11, target.get(0));
    }

    @Test
    public void testAddToEnd(){
        target.addToFront(11);
        target.addToEnd(12);
        target.addToEnd(13);

        Assert.assertEquals(12, target.get(1));
        Assert.assertEquals(13, target.get(2));
    }

    @Test
    public void testInsertValueAtIndex(){
        target.addToFront(11);
        target.addToEnd(12);
        target.insertValueAtIndex(1, 20);
        target.insertValueAtIndex(1, 10);

        Assert.assertEquals(10, target.get(1));
        Assert.assertEquals(20, target.get(2));

    }
}
