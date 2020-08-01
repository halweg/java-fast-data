package queue;

import java.util.List;

public class LinkedListQueue<E> implements Queue<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private int size;
    private Node head;
    private Node tail;

    public LinkedListQueue() {
        size = 0;
        head = null;
        tail = null;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void enqueue(E e) {
        //如果队列为空
        if (tail == null) {
            head = new Node(e);
            tail = head;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }

        size++;
    }

    @Override
    public E dequeue() {
        if (tail == null) {
            throw new IllegalArgumentException("dequeue failed queue is empty");
        }
        Node retNode = head;
        head = head.next;
        retNode.next = null;
        if (head == null) {
            tail = null;
        }
        size--;
        return retNode.e;
    }

    @Override
    public boolean isEmpty() {
        return tail == null;
    }

    @Override
    public E getFront() {
        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        s.append("fornt :");
        Node node = head;
        while (node != null) {
            s.append(node + "->");
            node = node.next;
        }
        s.append("NULL tail");
        return s.toString();
    }

    public static void main(String[] args) {
        LinkedListQueue<Integer> q = new LinkedListQueue<>();

        for (int i = 0; i <= 10; i++ ) {
            q.enqueue(i);
            System.out.println(q.toString());
        }
        System.out.println(q.dequeue());
        //System.out.println(q.dequeue());

        System.out.println(q.toString());
    }
}
