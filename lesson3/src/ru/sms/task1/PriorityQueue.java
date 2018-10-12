package ru.sms.task1;

public class PriorityQueue {
    private int[] stack;
    private int head;
    private boolean isSorted;

    public PriorityQueue(int size) {
        this.stack = new int[size];
        this.head = -1;
    }

    public boolean isEmpty() {
        return head == -1;
    }

    public boolean isFull() {
        return head == stack.length - 1;
    }

    public boolean insert(int i) {
        if (isFull())
            return false;
        stack[++head] = i;
        isSorted = false;
        return true;
    }

    public int pullMax() {
        if (isEmpty())
            throw new RuntimeException("Stack is empty");
        if (!isSorted)
            sortInsert();
        return stack[head--];
    }

    public int peek() {
        if (isEmpty())
            throw new RuntimeException("Stack is empty");
        return stack[head];
    }

    private void sortInsert() {
        int in;
        for (int out = 0; out <= head; out++) {
            int temp = stack[out];
            in = out;
            while (in > 0 && stack[in - 1] >= temp) {
                stack[in] = stack[in - 1];
                in--;
            }
            stack[in] = temp;
        }
        isSorted = true;
    }
}
