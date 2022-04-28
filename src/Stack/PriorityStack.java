package Stack;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

public class PriorityStack<T> {

    class Container<T> {
        T value;
        boolean hasPriority;
        Container<T> nextBelow;
    }

    private Container top; // top of the stack element
    private int size;

    public void push(T value) {
        Container<T> newContainer = new Container<>();
        newContainer.value = value;

        if (size != 0) {
            newContainer.nextBelow = top;
        }
        top = newContainer;
        size++;
    }

    public void push(T value, boolean hasPriority) {
        Container<T> newContainer = new Container<>();
        newContainer.value = value;
        newContainer.hasPriority = hasPriority;

        if (size != 0) {
            newContainer.nextBelow = top;
        }
        top = newContainer;
        size++;
    }

    public T pop() {
        // remove and return the top item
        // if no item found (size == 0) then throw NoSuchElementException
        if (size == 0) {
            throw new NoSuchElementException();
        }
        T value = (T) top.value;
        Container<T> temp = top.nextBelow;
        top.nextBelow = null;
        top = temp;

        return value;
    }

    public T popPriority() {
        // find item with priority starting from the top, remove it and return it
        // if no priority item found then remove and return the top item
        // if stack is empty then throw NoSuchElementException

        if (size == 0) {
            throw new NoSuchElementException();
        }
        Container current = top;
        if (size == 1){
            return this.pop();
        }
        while (current.nextBelow!= null && !current.nextBelow.hasPriority) {
            current = current.nextBelow;
        }
        if (current.nextBelow == null){
            return this.pop();
        }
        T value = (T) current.nextBelow.value;
        current.nextBelow = current.nextBelow.nextBelow;
        current.nextBelow.nextBelow = null;
        size--;

        return value;
    }

    public int hasValue(T value) {
        // returns -1 if value is not on the stack
        // this code only looks for the *first* occurence of the value, starting from top
        // WARNING: you must call value.equals(item.value) to determine whether
        // two values are equal, just like you would do for a String
        // returning value 0 means the value is on top of the stack,
        // 1 means 1 below the top, and so on...
        Container current = top;
        int position = 0;
        while(current != null){
            if (current.value.equals(value)){
                return position;
            }
            current = current.nextBelow;
            position++;
        }
        return -1;
    }

    public T removeValue(T value) {
        // removes the first item from top containing the value and returns the value
        // if item with value is not found throw NoSuchElementException
        int index = hasValue(value);

        if (index == -1){
            throw new NoSuchElementException();
        }
        if (index == 0){
            return pop();
        }
        if(index == size - 1){
            return removeLast();
        }
        Container current = top;
        int position = 0;
        while(current.nextBelow != null){
            if (position == index - 1){
                Container temp = current.nextBelow.nextBelow;
                current.nextBelow.nextBelow = null;
                current.nextBelow = temp;
                size--;
            }
            current = current.nextBelow;
            position++;
        }
        return value;
    }

    public int getSize() {
        return size;
    }

    private T removeLast(){
        Container current = top;
        while (current.nextBelow.nextBelow != null){
            current = current.nextBelow;
        }
        T value = (T) current.nextBelow.value;
        current.nextBelow = null;
        size--;
        return value;
    }
    public void reorderByPriority() {
        // reorder items (re-create a new stack, if you like)
        // where all priority items are on top and non-priority items are below them
        // Note: order within the priority items group and non-priority items group must remain the same
        // Suggestion: instead of reordering the existing stack items
        // it may be easier to re-create a new stack with items in the order you need
        PriorityStack newStack1 = new PriorityStack();
        PriorityStack newStack2 = new PriorityStack();

        Container current = top;

        while (current != null){
            newStack1.push(current.value, current.hasPriority);
            current = current.nextBelow;
        }

        Container newCurrent = newStack1.top;
        while (newCurrent != null){
            if (!newCurrent.hasPriority){
                newStack2.push(newCurrent.value, newCurrent.hasPriority);
            }
            newCurrent = newCurrent.nextBelow;
        }
        newCurrent = newStack1.top;
        while (newCurrent != null){
            if (newCurrent.hasPriority){
                newStack2.push(newCurrent.value, newCurrent.hasPriority);
            }
            newCurrent = newCurrent.nextBelow;
        }
        top = newStack2.top;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Container current = top;
        builder.append("[");
        while(current != null){
            builder.append(current == top? "":",");
            builder.append(current.value.toString());
            builder.append(current.hasPriority ? ":P":":N");
            current = current.nextBelow;
        }
        builder.append("]");
        return builder.toString();
    }

    public T[] toArrayReversed(Class<T> type) { // Note: this is "the twist"
    // return array with items on the stack
    // WARNING: element 0 of the array must be the BOTTOM of the stack
    // NOTE: To obtain full marks for this method you must use recursion.
    // Collect items on your way back, just before returning.
    // This case is similar to when constructors of parent classes are called (Programming II course).
//        T[] result = (T[]) Array.newInstance(type, size);
        T[] result = (T[])Array.newInstance(type, size);
        Container current = top;
        for (int i = size-1; i >= 0; i--){
            if (current != null){
                result[i] = (T) current.value;
                current = current.nextBelow;
            }
        }
        return result;
    }
}
// NOTE: you are only allowed to add private methods and private fields (if needed)
