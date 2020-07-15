package queue;

import array.Array;

import java.util.Calendar;

public class ArrayQueue<E> implements Queue<E> {

    Array<E> queue;

    public ArrayQueue (int capacity) {
        queue = new Array<>(capacity);
    }

    public ArrayQueue () {
        queue = new Array<>();
    }

    public int getCapacity() {
        return queue.getSize();
    }

    @Override
    public int getSize(){
        return queue.getSize();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        queue.addLast(e);
    }

    @Override
    public E dequeue() {
        return queue.removeFirst();
    }

    @Override
    public E getFront() {
        return queue.getFirst();
    }

    public String toString() {
        StringBuilder ret = new StringBuilder();

        ret.append("Queue front->[");

        for (int i = 0; i < queue.getSize(); i++) {
            ret.append(queue.get(i));
            if ( i < queue.getSize() - 1 ) {
                ret.append(",");
            }
        }

        ret.append("]<-tail");

        return ret.toString();
    }
}
