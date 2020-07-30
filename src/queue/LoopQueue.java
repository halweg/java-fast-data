package queue;

import array.Array;

//循环队列，记录队首和队尾。front == tail 的时候，对列为空
//当 tail + 1 == front 时，队列满。此时考虑到循环，补充为 (tail + 1) % capacity == front 时，队列满
public class LoopQueue<E> implements Queue<E> {

    private E[] data;

    private int fornt, tail;

    private int size;


    public LoopQueue(int capacity) {
        data =  (E[]) new Object[capacity + 1];
        fornt = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity() {
        return data.length - 1;
    }

    public boolean isEmpty() {
        return tail == fornt;
    }

    public int getSize() {
        return size;
    }

    //入队操作
    public void enqueue(E e) {

        //队列满的情况
        if ( (tail + 1) % data.length == fornt) {
            //进行数组扩容
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        size++;
        tail = (tail + 1) % data.length;
    }

    //出队操作
    private void resize(int newCapacity) {

       E[] arr = (E[]) new Object[newCapacity + 1];
        for (int i=0; i < size; i++) {
            arr[i] = data[ (i + fornt ) % data.length ];
        }

        data = arr;
        fornt = 0;
        tail = size;
    }

    public E  dequeue() {

        if (isEmpty())
            throw new IllegalArgumentException("the queue is Empty");

        E ret = data[fornt];
        data[fornt] = null;
        size--;
        fornt = (fornt + 1) % data.length;

        if (size == getCapacity() / 4 && data.length / 2 != 0) {
            resize(data.length/2);
        }

        return ret;
    }

    public E getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("the queue is Empty");

        return data[fornt];
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();

        res.append(String.format("Queue size=%d,capacity=%d", size, getCapacity()));
        res.append(" front: [");
        for (int i = fornt; i != tail ; i = (i + 1) % data.length ) {

            res.append(data[i]);

            if ((i + 1) % data.length != tail) {
                res.append(",");
            }
        }
        res.append("] tail");
        return res.toString();

    }

}
