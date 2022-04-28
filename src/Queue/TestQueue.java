package Queue;

import org.junit.Assert;
import org.junit.Test;

public class TestQueue {
    ArrayQueue target = new ArrayQueue();

    @Test
    public void testEnQueue(){
        target.display();
        target.enQueue(1);
        target.enQueue(2);
        target.enQueue(3);
        target.enQueue(4);

        target.display();
        Assert.assertEquals(1, target.getFrontValue());
        Assert.assertEquals(4, target.getBackValue());
    }

    @Test
    public void testDeQueue(){
        target.enQueue(1);
        target.enQueue(2);
        target.enQueue(3);
        target.enQueue(4);
        target.deQueue();

        Assert.assertEquals(2, target.getFrontValue());
        Assert.assertEquals(4, target.getBackValue());
    }

    @Test
    public void testGetSize(){
        Assert.assertEquals(0, target.getSize());

        target.enQueue(1);

        Assert.assertEquals(1, target.getSize());
        target.enQueue(2);
        target.enQueue(3);
        target.enQueue(4);

        Assert.assertEquals(4, target.getSize());

        target.deQueue();
        Assert.assertEquals(3, target.getSize());
    }
}
