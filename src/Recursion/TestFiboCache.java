package Recursion;

import org.junit.Assert;
import org.junit.Test;


public class TestFiboCache {

    FiboCache target = new FiboCache();

    @Test
    public void testFiboCache(){
        Assert.assertEquals(13, target.getNthFib(8));
        Assert.assertEquals(21, target.getNthFib(9));
        Assert.assertEquals(34, target.getNthFib(10));
        Assert.assertEquals(0, target.getNthFib(1));
        Assert.assertEquals(1, target.getNthFib(2));
        Assert.assertEquals(10, target.getCountOfFibsComputed());
        System.out.println(target.toString());
    }
}
