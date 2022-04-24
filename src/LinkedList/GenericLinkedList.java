package LinkedList;

public class GenericLinkedList<T> {

    private class Container{
        Container next;
        T value;

        public Container(T value) {
        }
    }

    private Container start, end;
    private int size;

    public void addToFront(T value) {
        Container newFront = new Container(value);

        if (size == 0) {
            start = newFront;
            end = newFront;
            size++;
        } else {
            newFront.next = start;
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
            end.next = newEnd;
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
                current = current.next;
            }
            return current.value;
        }
    }

    public void add(T value) {
        this.addToEnd(value);
    }

    public void insertValueAtIndex(int index, T value) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (index == 0) {
            this.addToFront(value);
        } else if (index == size || size == 0) {
            this.addToEnd(value);
        } else {
            Container newNode = new Container(value);
            Container current = start;
            for (int i = 0; i < index - 1; i++){
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
            size++;
        }
    }

    public void deleteByIndex(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        Container current = start;

        if (index == 0) {
            start = current.next;
            size--;
        } else {
            int position = 0;
            while (position < index - 1) {
                current = current.next;
                position++;
            }
            if (position == size - 2) {
                end = current;
            } else {
                current.next = current.next.next;
            }
            size--;
        }
    }

    public boolean deleteByValue(T value) { // delete first value found
        Container current = start;
        if (current.value == value) {
            start = current.next;
        }
        while (current.next != null) {
            if (current.next.value == value) {
                if (current.next.next == null) {
                    end = current;
                    size--;
                    return true;
                }
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        Container curr = start;
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        while (curr != null) {
            builder.append(curr == start ? "" : ",");
            builder.append(curr.value);
            curr = curr.next;
        }
        builder.append("]");
        return builder.toString();
    }


    public T[] toArray(T[] templateType) {
//        T[] result = new T[size];
        T[] result = (T[])java.lang.reflect.Array.newInstance(templateType.getClass().getComponentType(), size);
        Container current = start;
        for (int i = 0; i < size; i++) {
            result[i] = current.value;
            current = current.next;
        }
        return result;
    }

}
