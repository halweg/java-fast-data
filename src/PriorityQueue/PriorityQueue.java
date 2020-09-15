package PriorityQueue;

import MaxHeap.MaxHeap;
import queue.Queue;

public class PriorityQueue<E extends Comparable<E> > implements Queue<E> {

    private MaxHeap<E> maxHeap;

    public PriorityQueue() {
        maxHeap = new MaxHeap<E>();
    }

    public E dequeue() {
        return maxHeap.extractMax();
    }

    public E getFront(){
        return maxHeap.findMax();
    }

    public boolean isEmpty(){
        return maxHeap.isEmpty();
    }

    public int getSize(){
        return maxHeap.getSize();
    }

    public void enqueue(E e)  {
        maxHeap.add(e);
    }


}
