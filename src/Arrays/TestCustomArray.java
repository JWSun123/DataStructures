package Arrays;

import org.junit.Assert;
import org.junit.Test;

public class TestCustomArray {

    CustomArrayOfInt target = new CustomArrayOfInt();

    @Test
    public void testAddElement(){
        target.add(2);
        Assert.assertEquals(1, target.size());
        Assert.assertEquals(2, target.get(0));

    }

    @Test
    public void testDeleteByIndex(){
        System.out.println(target.size());
        target.add(2);
        target.deleteByIndex(0);
        Assert.assertEquals(0, target.size());

    }

    @Test
    public void testDeleteByValue(){
        target.add(20);
        target.add(25);
        // assertTrue;
        Assert.assertTrue(target.deleteByValue(20));
        Assert.assertEquals(1, target.size());
        Assert.assertEquals(25, target.get(0));
    }

    @Test
    public void testInsertValueAtIndex(){
        target.add(20);
        target.add(25);
        target.insertValueAtIndex(88, 1);
        Assert.assertEquals(88, target.get(1));
        Assert.assertEquals(3, target.size());
        Assert.assertEquals(25, target.get(2));
        Assert.assertEquals(20, target.get(0));
    }

    @Test
    public void testClear(){
        target.add(20);
        target.add(25);
        target.clear();
        Assert.assertEquals(0, target.size());
    }

    @Test
    public void testGetSlice(){
        target.add(11);
        target.add(12);
        target.add(13);
        target.add(14);
        target.add(15);
        target.add(16);

        Assert.assertArrayEquals(new int[]{12,13,14}, target.getSlice(1, 3));
    }

    @Test
    public void testToString(){
        target.add(20);
        target.add(25);
        Assert.assertEquals("[20, 25]", target.toString());
    }

    // NEGATIVE Test
    @Test(expected = IndexOutOfBoundsException.class)
    public void testIndexOutOfBoundsException() {
        target.get(10);
        target.deleteByIndex(10);
        target.insertValueAtIndex(100, 10);
    }
}
