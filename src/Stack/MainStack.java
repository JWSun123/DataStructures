package Stack;

import org.junit.Assert;

import java.util.Arrays;

public class MainStack {
    public static void main(String[] args) {
//        ArrayStack stack1 = new ArrayStack(5);
//        stack1.push(new Employee("Tom", "Sawyer", 1));
//        stack1.push(new Employee("Tony", "Stark", 2));
//        stack1.push(new Employee("Steve", "Rogers", 3));
//
//        stack1.printStack();
//
//        System.out.println("pop: "+stack1.pop());
//        stack1.printStack();

//        PriorityStack<String> instance = new PriorityStack<>();
////        System.out.println(instance.getTop());
//        instance.push("Jerry");
//        System.out.println(instance.toString());
//        System.out.println(instance.getSize());
//        instance.push("Terry", true);
//        System.out.println(instance.toString());
//        System.out.println(instance.getSize());
//
//        instance.push("Barry");
//        System.out.println(instance.toString());
//        instance.push("Larry", true);
//        System.out.println(instance.getSize());
//        System.out.println(instance.toString());
//        String res1 = instance.popPriority();
//        System.out.println("Expected Larry, got " + res1);
//
//
//        Object [] result = instance.toArrayReversed(String.class);
//        Object [] expected = {"Jerry", "Terry", "Larry", "Barry" };
//        System.out.println("result: "+Arrays.toString(result));
//        Assert.assertArrayEquals(expected, result);


        PriorityStack<String> instance = new PriorityStack<>();
        instance.push("Jerry", false);
        instance.push("Terry");
        instance.push("Larry", true);
        instance.push("Barry");
        instance.push("Eva", true);
        instance.push("Martha");
        instance.push("Ruth");
        System.out.println(instance.toString());
        instance.reorderByPriority();
        System.out.println("Expected: [Eva:P,Larry:P,Ruth:N,Martha:N,Barry:N,Terry:N,Jerry:N]");
        System.out.println("Result  : " + instance.toString());

        System.out.println(instance.removeValue("Barry"));
        System.out.println(instance.toString());
    }
}
