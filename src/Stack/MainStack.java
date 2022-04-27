package Stack;

public class MainStack {
    public static void main(String[] args) {
        ArrayStack stack1 = new ArrayStack(5);
        stack1.push(new Employee("Tom", "Sawyer", 1));
        stack1.push(new Employee("Tony", "Stark", 2));
        stack1.push(new Employee("Steve", "Rogers", 3));

        stack1.printStack();

        System.out.println("pop: "+stack1.pop());
        stack1.printStack();
    }
}
