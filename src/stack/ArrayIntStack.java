package stack;

public class ArrayIntStack implements IntStack {
    private int[] array;
    private int size;

    public ArrayIntStack() {
        array = new int[5];
        size = 0;
    }

    @Override
    public void push(int value) {
        if (size < array.length) {
            array[size] = value;
            size++;
        } else {
            int[] arrayNew = new int[size * 2];
            for (int i = 0; i < size; i++) {
                arrayNew[i] = array[i];
            }
            arrayNew[size] = value;
            array = arrayNew;
            size++;
        }
    }

    @Override
    public int pop() throws Exception {
        if (size == 0) {
            throw new Exception("Stack is empty");
        }
        int result = array[size - 1];
        size--;
        return result;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        array = new int[5];
        size = 0;
    }

    @Override
    public String toString() {
        String result = "[";
        if (size == 0) {
            result = "Queue is empty";
        } else {
            result = result + Integer.toString(array[0]);
            for (int i = 1; i < size; i++) {
                result = result + ", " + Integer.toString(array[i]);
            }
            result = result + "]";
        }
        return result;
    }
}
