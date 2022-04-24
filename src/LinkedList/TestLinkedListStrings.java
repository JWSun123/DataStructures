package LinkedList;

import org.junit.Assert;
import org.junit.Test;

public class TestLinkedListStrings {
    LinkedListArrayOfStrings target = new LinkedListArrayOfStrings();

    @Test
    public void testAdd(){
        target.addToFront("aa");
        target.addToFront("bb");

        Assert.assertEquals("aa", target.get(0));
        Assert.assertEquals("bb", target.get(1));
    }

    @Test
    public void testInsertByIndex(){
        target.addToFront("aa");
        target.addToFront("bb");
        target.insertValueAtIndex(1, "cc");

        Assert.assertEquals("cc", target.get(1));
    }

    @Test
    public void testDelete(){
        target.addToFront("aa");
        target.addToFront("bb");

        target.deleteByIndex(0);
        Assert.assertEquals("bb", target.get(0));
    }
}
