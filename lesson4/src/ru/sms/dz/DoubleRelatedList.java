package ru.sms.dz;

public class DoubleRelatedList <T> {

    private Node head;
    private Node tail;

    private class Node {
        T instance;
        Node next;
        Node prev;
        public Node(T instance) {
            this.instance = instance;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            if (!instance.equals(node.instance)) return false;
            if (next != null ? !next.equals(node.next) : node.next != null) return false;
            return prev != null ? prev.equals(node.prev) : node.prev == null;
        }

        @Override
        public String toString() {
            return instance.toString();
        }
    }

    public DoubleRelatedList() {
        head = null;
        tail = null;
    }
    public boolean isEmpty() {
        return head == null;
    }

    public void putHead(T instance){
        final Node node = new Node(instance);
        if (isEmpty())
            tail = node;
        node.next = head;
        if (head != null)
            head.prev = node;

        head = node;
    }

    public void putTail(T instance){
        final Node node = new Node(instance);
        node.prev = tail;
        tail.next = node;
        tail = node;
    }

    public T popHead(){
        if (isEmpty())
            return null;
        final T instance = head.instance;
        final Node next = head.next;
        next.prev = null;
        head = next;
        return instance;
    }

    public T popTail(){
        if (isEmpty())
            return null;
        final T instance = tail.instance;

        final Node prev = head.prev;
        prev.next = null;
        tail = prev;
        return instance;
    }

    public boolean remove(T instance){
        if (isEmpty())
            return false;
        Node node = new Node(instance);
        Node current = head;

        while (!current.equals(node)) {
            if (current.next == null)
                return false;
            else {
                current = current.next;
            }
        }
        if (current == head) {
            head = head.next;
            head.prev = null;
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        return true;
    }

    public boolean contains(T instance) {
        if (isEmpty())
            return false;
        Node current = head;
        while (!current.instance.equals(instance)) {
            if (current.next == null)
                return false;
            else
                current = current.next;
        }
        return true;
    }
}
