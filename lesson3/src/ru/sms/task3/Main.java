package ru.sms.task3;

public class Main {
    public static void main(String[] args) {
        final Deque deque = new Deque(8);
        deque.pushBack(5);
        deque.pushBack(6);
        deque.pushBack(7);

        deque.pushFront(4);
        deque.pushFront(3);
        deque.pushFront(2);

        System.out.println(deque.popFront());
        System.out.println(deque.popFront());

        deque.pushBack(8);
        deque.pushBack(9);
        deque.pushBack(10);
        deque.pushBack(11);

        System.out.println(deque.popFront());
        System.out.println(deque.popFront());
        System.out.println(deque.popFront());

        deque.pushBack(12);
        deque.pushBack(13);
        deque.pushBack(14);

        System.out.println(deque.popBack());
        System.out.println(deque.popBack());
        System.out.println(deque.popBack());

    }
}
