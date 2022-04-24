package Arrays;

public class CustomArrayOfInt {
    public int[] data = new int[1]; //only grows by doubling size, never shrinks.
    private int size = 0;

    public CustomArrayOfInt() {
    }

    public int size() {
        return size;
    }

    public void add(int value) {
        if (size == data.length) {
            this.growStorage();
        }
        data[size] = value;
        size++;
    }

    public void deleteByIndex(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        //shifting data from right to left.
        if (size - (index + 1) >= 0) System.arraycopy(data, index + 1, data, index + 1 - 1, size - (index + 1));
//        same as above.
//        for (int i = index + 1; i < size; i++) {
//            data[i-1] = data[i];
//        }
        size--;

        //shrink. when to shrink.
        if ((double) size / data.length * 100 < 25) {
            shrinkStorage();
        }
    }

    public boolean deleteByValue(int value) {
        for (int i = 0; i < size; i++) {
            if (data[i] == value) {
                this.deleteByIndex(i);
                return true;
            }
        }

        return false;
    } // delete first value matching, true if value found, false otherwise

    public void insertValueAtIndex(int value, int index) {
        if (size == data.length) {
            this.growStorage();
        }
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        // shifting from left to right. start from the end, go backward.
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
//         similar using arraycopy.
//        if (size - 1 - index >= 0) System.arraycopy(data, index + 1, data, index + 1 + 1, size - 1 - index);

        data[index] = value;
        size++;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            this.deleteByIndex(i);
        }
        size = 0;
    }

    public int get(int index) { // may throw IndexOutOfBoundsException
        if (index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        } else {
            return data[index];
        }
    }

    public int[] getSlice(int startIdx, int length) {
        int[] result = new int[length];
        if (startIdx < 0 || length < 0 || startIdx + length > size) {
            throw new IndexOutOfBoundsException();
        }
        for(int i = 0; i < length; i++){
            result[i] = data[i+startIdx];
        }
        return result;
    } // may throw IndexOutOfBoundsException


    @Override
    public String toString() {
        String s = "[";
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                s += data[i];
            } else {
                s += ", " + data[i];
            }
        }
        s += "]";
        return s;
    } // returns String similar to: [3, 5, 6, -23]

    public void growStorage() {
        // a helper variable.
        int[] newData = new int[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            // transfer data from data to newdata.
            newData[i] = data[i];
        }
        data = newData;
    }

    public void shrinkStorage() {
        // a helper variable.
        int[] newData = new int[data.length / 2];
        for (int i = 0; i < size; i++) {
            // transfer data from data to newdata.
            newData[i] = data[i];
        }
        data = newData;
    }
}

