package test;

import queue.ArrayIntQueue;
import queue.IntQueue;
import stack.ArrayIntStack;
import stack.IntStack;

public class Exercise {
    public static int evenCount(IntStack stk) throws Exception{
        int count = 0;
        IntStack tempStack = new ArrayIntStack();
        while (stk.getSize()!=0) {
            int element = stk.pop();
            if(element%2==0) {
                count++;
            }
            tempStack.push(element);
        }
        while(tempStack.getSize() !=0) {
            stk.push(tempStack.pop());
        }
        return count;
    }

    public static IntQueue copyQueue(IntQueue orig) throws Exception {
        IntQueue result = new ArrayIntQueue();
        for (int i=0; i<orig.getSize(); i++) {
            int element = orig.dequeue();
            result.enqueue(element);
            orig.enqueue(element);
        }
        return result;
    }

    public static void reverseStack(IntStack toRev) throws Exception{
        IntQueue queue = new ArrayIntQueue();
        while(toRev.getSize() !=0) {
            queue.enqueue(toRev.pop());
        }
        while (queue.getSize() != 0) {
            toRev.push(queue.dequeue());
        }
    }

    public static void reverseQueue(IntQueue toRev) throws Exception{
        IntStack stack = new ArrayIntStack();
        while(toRev.getSize() !=0) {
            stack.push(toRev.dequeue());
        }
        while (stack.getSize() != 0) {
            toRev.enqueue(stack.pop());
        }
    }

    public static boolean isPalindrome(IntQueue q) throws Exception {
        IntQueue copy = copyQueue(q);
        IntQueue reversedCopy = copyQueue(q);
        reverseQueue(reversedCopy);
        while(copy.getSize()!=0) {
            if(copy.dequeue() != reversedCopy.dequeue()) {
                return false;
            }
        }
        return true;
    }

    public static void insert(IntStack st, int pos, int val) throws Exception {
        IntStack st2 = new ArrayIntStack();
        while (st.getSize() != 0) {
            st2.push(st.pop());
        }
        for (int i=0; i<pos; i++) {
            st.push(st2.pop());
        }
        st.push(val);
        while(st2.getSize() != 0) {
            st.push(st2.pop());
        }
    }

    public static IntStack merge(IntStack s1, IntStack s2) throws Exception {
        IntStack stackNew = new ArrayIntStack();


        return stackNew;
    }
}
