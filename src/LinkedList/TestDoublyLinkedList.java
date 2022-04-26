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
        target.insertValueAtIndex(1, 30);

        Assert.assertEquals(30, target.get(1));
        Assert.assertEquals(20, target.get(2));
        Assert.assertEquals(30, target.getLeftValue(2));
        Assert.assertEquals(20, target.getRightValue(1));
    }

    @Test
    public void testDeleteByIndex(){
        target.addToFront(11);
        target.addToEnd(12);
        target.insertValueAtIndex(1, 20);
        target.insertValueAtIndex(1, 30);
        target.deleteByIndex(1);
        Assert.assertEquals(20, target.get(1));
    }

    @Test
    public void testDeleteByValue(){
        target.addToFront(11);
        target.addToEnd(12);
        target.insertValueAtIndex(1, 20);
        target.insertValueAtIndex(1, 30);
        target.deleteByValue(20);
        Assert.assertEquals(12, target.get(2));
        Assert.assertEquals(30, target.getLeftValue(2));
        Assert.assertEquals(12, target.getRightValue(1));

        target.deleteByValue(12);

        Assert.assertEquals(30, target.get(1));
        Assert.assertEquals(11, target.get(0));

    }
}
