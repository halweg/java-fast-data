package LinkedList;

import jdk.dynalink.NamedOperation;
import queue.LoopQueue;

import java.util.logging.Logger;

public class LinkedList<E> {

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

    private Node dummyHead;

    private int size;

    public LinkedList() {
        size = 0;
        dummyHead = new Node(null, null);
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //在链表的index位置插入一个元素
    public void add(int index, E e) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index is error");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = new Node(e, prev.next);
        size++;
    }

    public void addLast(E e) {
        add(size, e);
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public E get(int index) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index is error");
        }

        Node curr = dummyHead.next;

        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }

        return curr.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size);
    }

    public void setIndex(int index, E e) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index is error");
        }

        Node curr = dummyHead;

        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }

        curr.e = e;
    }

    public boolean contains(E e) {

        Node curr = dummyHead.next;

        while (null != curr) {

            if (curr.e == e) {
                return true;
            }

        }
        return false;
    }

    public E remove(int index) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index is error");
        }

        Node prev = dummyHead;

        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        Node retNode = prev.next;

        prev.next = retNode.next;

        retNode.next = null;

        size--;

        return retNode.e;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size-1);
    }

    public String toString() {

        StringBuilder s = new StringBuilder();
        Node curr = dummyHead.next;

        while (null != curr) {

            s.append(curr + "->");

            curr = curr.next;

        }

        s.append("Null");

        return s.toString();
    }

}
