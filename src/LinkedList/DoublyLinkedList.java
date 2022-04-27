package LinkedList;

public class DoublyLinkedList<T> {

    private class Container {
        Container left;
        Container right;
        T value;

        public Container(T value) {
            this.value = value;
        }

        public Container() {
        }

    }

    private Container start, end;
    private int size;

    public Container getContainer(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }else {
            Container current = new Container();
            current = start;
            for (int i = 0; i < index; i++) {
                current = current.right;
            }
            return current;
        }
    }

    public T getLeftValue(int index) {
        Container container = getContainer(index);
        return container.left.value;
    }

    public T getRightValue(int index) {
        Container container = getContainer(index);
        return container.right.value;
    }

    public void addToFront(T value) {
        Container newFront = new Container(value);

        if (size == 0) {
            start = newFront;
            end = newFront;
            size++;
        } else {
            start.left = newFront;
            newFront.right = start;
            start = newFront;
            size++;
        }
    }

    public void addToEnd(T value) {
        Container newEnd = new Container(value);

        if (size == 0) {
            start = newEnd;
            end = newEnd;
            size++;
        } else {
            end.right = newEnd;
            newEnd.left = end;
            end = newEnd;
            size++;
        }
    }

    public T get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (index == 0) {
            return start.value;
        } else if (index == size - 1) {
            return end.value;
        } else {
            Container current = start;
            for (int i = 0; i < index; i++) {
                current = current.right;
            }
            return current.value;
        }
    }

    public void insertValueAtIndex(int index, T value) {
        if (index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (index == 0) {
            this.addToFront(value);
        } else if (index == size || size == 0) {
            this.addToEnd(value);
        } else {
            Container newNode = new Container(value);
            Container current = start;
            for (int i = 0; i < index - 1; i++) {
                current = current.right;
            }
            newNode.right = current.right;
            newNode.left = current;
            current.right.left = newNode;
            current.right = newNode;
            size++;
        }
    }

    public void deleteByIndex(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Container current = start;
        if (index == 0) {
            start = start.right;
            start.left = null;
            size--;
        }
        else {
            for(int i = 0; i < index; i++) {
                current = current.right;
            }
            if (index == size - 1) {
                current.left.right = null;
                end = current.left;
                current.left = null;
                size--;
            }
            current.left.right = current.right;
            current.right.left = current.left;
            current.left = null;
            current.right = null;
            size--;
        }
    }

    public boolean deleteByValue(T value){
        Container current = start;
        if (current.value == value){
            start = start.right;
            start.left = null;
            size--;
            return true;
        }
        else{
            int position = 0;
            while (current.right != null) {
                current = current.right;
                position++;
                if (current.value == value){
                    if (position == size - 1) {
                        current.left.right = null;
                        end = current.left;
                        current.left = null;
                    } else {
                        current.left.right = current.right;
                        current.right.left = current.left;
                        current.left = null;
                        current.right = null;
                    }
                    size--;
                    return true;
                }
            }
            return false;
        }
    }

    @Override
    public String toString() {
        Container curr = start;
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        while (curr != null) {
            builder.append(curr == start ? "" : ",");
            builder.append(curr.value);
            curr = curr.right;
        }
        builder.append("]");
        return builder.toString();
    }

}
