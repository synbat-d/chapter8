package test;

import queue.ArrayIntQueue;
import queue.IntQueue;
import stack.ArrayIntStack;
import stack.IntStack;

public class Test {
    public static void main(String[] args) throws Exception{
        IntStack stack = new ArrayIntStack();
        for (int i=0; i<12; i++) {
            stack.push(i*i*2+5);
        }
        System.out.println(stack);
        Exercise.insert(stack, 5, -24);
        System.out.println(stack);
    }
}
