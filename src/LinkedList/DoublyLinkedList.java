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

    public T get(int index){
        if (index >= size){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (index == 0){
            return start.value;
        }else if (index == size - 1){
            return end.value;
        }else{
            Container current = start;
            for ( int i = 0; i < index; i++){
                current = current.right;
            }
            return current.value;
        }
    }

    public void insertValueAtIndex(int index, T value){
        if (index > size){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (index == 0) {
            this.addToFront(value);
        } else if (index == size || size == 0) {
            this.addToEnd(value);
        }else{
            Container newNode = new Container(value);
            Container current = start;
            for ( int i = 0; i < index - 1; i++){
                current = current.right;
            }
            newNode.right = current.right;
            current.right = newNode;
            size++;
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
