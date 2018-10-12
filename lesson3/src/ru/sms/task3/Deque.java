package ru.sms.task3;

import ru.sms.Queue;

public class Deque extends Queue {
    public Deque(int size) {
        super(size);
    }

    public void pushBack(int i){
        super.insert(i);
    }

    public void pushFront(int i){
        if (isFull()){
            super.increaseQueueSize();
        }

        if (head == 0)
            head = size;
        queue[--head] = i;
        items++;
    }

    public int popFront(){
        return super.remove();
    }

    public int popBack(){
        if (isEmpty())
            throw new RuntimeException("Queue is empty");
        int temp = queue[tail--];
        if (tail == -1)
            tail += size;
        items--;
        return temp;
    }
}
