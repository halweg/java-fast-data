package stack;


import LinkedList.LinkedList;

public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> list;

    public LinkedListStack() {
        list = new LinkedList<E>();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public boolean isEmpty() {
        return list.getSize() == 0;
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public E pop() {
        E ret = list.getFirst();
        list.removeFirst();
        return ret;
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();

        res.append("Stack: ");

        res.append(list);

        return res.toString();

    }




}
