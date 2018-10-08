package ru.sms.task1;

public class Main {
    public static void main(String[] args) {
        final PriorityQueue priorityQueue = new PriorityQueue(50);
        priorityQueue.insert(5);
        priorityQueue.insert(4);
        priorityQueue.insert(8);
        priorityQueue.insert(15);
        priorityQueue.insert(25);
        priorityQueue.insert(2);
        priorityQueue.insert(0);

        System.out.println(priorityQueue.pullMax());
        System.out.println(priorityQueue.pullMax());
        System.out.println(priorityQueue.pullMax());

        priorityQueue.insert(-5);
        priorityQueue.insert(1);
        System.out.println();
        System.out.println(priorityQueue.pullMax());
        System.out.println(priorityQueue.pullMax());
    }
}
