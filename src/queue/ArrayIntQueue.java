package queue;

public class ArrayIntQueue implements IntQueue {
    private int[] array;
    private int size;
    private int front;
    private int back;

    public ArrayIntQueue() {
        array = new int[5];
        size = 0;
    }

    @Override
    public void enqueue(int value) {
        if(size==0) {
            array[0]=value;
            front = 0;
            back = 0;
            size++;
            return;
        }
        if (size < array.length) {
            if(back < array.length-1) {
                array[back+1] = value;
                back++;
                size++;
            }
            else {
                back = 0;
                array[back] = value;
                size++;
            }
        }
        else {
            int [] arrayNew = new int[size*2];
            if(back>front) {
                int i;
                for (i=0; i<array.length; i++) {
                    arrayNew[i] = array[i];
                }
                arrayNew[i] = value;
                array = arrayNew;
                back = i;
                size++;
            }
            else {
                int j = 0;
                for (int i=front; i<array.length; i++ ) {
                    arrayNew[j] = array[i];
                    j++;
                }
                for  (int i=0; i<front; i++) {
                    arrayNew[j] = array[i];
                    j++;
                }
                arrayNew[j] = value;
                back = j;
                front = 0;
                array = arrayNew;
                size++;
            }
        }
    }

    @Override
    public int dequeue() throws Exception {
        if(size==0) {
            throw new Exception("there is no element inside the queue");
        }
        int result = array[front];
        if(front+1<array.length) {
            front++;
        }
        else {
            front = 0;
        }
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
        String result="[";
        if (size==0) {
            result = "Queue is empty";
        }
        else {
            if (front<back) {
                result = result + Integer.toString(array[front]);
                for (int i=front+1; i<=back; i++) {
                    result = result + ", " + Integer.toString(array[i]);
                }
                result = result + "]";
            } else {
                result = result + Integer.toString(array[front]);
                for (int i=front+1; i<array.length; i++) {
                    result = result + ", " + Integer.toString(array[i]);
                }
                for(int i=0; i<=back; i++) {
                    result = result + ", " + Integer.toString(array[i]);
                }
                result = result + "]";
            }
        }
        return result;
    }
}
