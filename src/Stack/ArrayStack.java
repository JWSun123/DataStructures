package Stack;

import java.util.EmptyStackException;

public class ArrayStack {
    private int top;
    private Employee[] stack;

    public ArrayStack(int capacity) {
        stack = new Employee[capacity];
    }

    public void push(Employee employee) {
        if (top == stack.length){
            Employee[] newArray = new Employee[2*stack.length];
            System.arraycopy(stack, 0, newArray, 0, stack.length);
            stack = newArray;
        }
        stack[top++] = employee;
    }

    public Employee pop() {
        if(top == 0){
            throw new EmptyStackException();
        }
        Employee employee = stack[--top]; // --top => the top element will be disappeared.
        return employee;
    }

    public Employee peek() {
//        if (stack == null) {
//            return null;
//        }
        if(top == 0){
            throw new EmptyStackException();
        }
        return stack[top-1];
    }

    public int size() {
        return top;
    }

    public boolean isEmpty() {
        return top==0;
    }

    public void printStack() {
        System.out.println("-------");
        for ( int i = top-1; i >= 0; i--){
            System.out.println(stack[i]);
        }
        System.out.println("-------");
    }

    public Employee get(int index){
        if (index < 0 || index >= stack.length){
            throw new IndexOutOfBoundsException();
        }
        return stack[index];
    }
}


class Employee {
    private String firstName;
    private String lastName;
    private int id;

    public Employee(String firstName, String lastName, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id=" + id +
                '}';
    }
}