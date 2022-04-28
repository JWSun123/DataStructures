package Queue;

public class ArrayQueue {
    int queueLength = 3;
    int items[] = new int[queueLength];
    int front = -1;
    int back = -1;

    public int getFront() {
        return front;
    }

    public int getBack() {
        return back;
    }

    public int getFrontValue() {
        return items[front];
    }

    public int getBackValue() {
        return items[back];
    }

    public int getSize() {
        if (isEmpty()) {
            return 0;
        }
        if (back == 0 && front == 0) {
            return 1;
        }
        return back - front + 1;
    }

    boolean isEmpty() {
        if (front == -1 && back == -1) {
            return true;
        }
        return false;
    }

    boolean isFull() {
        if (back == queueLength - 1) {
            return true;
        }
        return false;
    }

    void enQueue(int itemValue) {
        if (isEmpty()) {
            front++;
            items[++back] = itemValue;
        } else if (isFull()) {
            int[] newArray = new int[2 * items.length];
            System.arraycopy(items, 0, newArray, 0, items.length);
            items = newArray;
            items[++back] = itemValue;
        } else {
            items[++back] = itemValue;
        }
    }

    void deQueue() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Queue is empty. Nothing to dequeue.");
        } else if (front == back) {
            front = back = -1;
        } else {
            front++;
        }
    }

    void display() {

        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        for (int i = front; i <= back; i++) {
            System.out.printf("%d%s", items[i], i == back ? "\n" : ", ");
        }
    }
}
