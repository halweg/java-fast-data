package array;

public class Array<T> {

    private T[] data;

    private int size;


    public Array(int capacity){
        data  = (T[]) new Object[capacity];
        size = 0;
    }

    public Array() {
        this(10);
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return this.data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addLast(T e) {
        add(size, e);
    }

    public void add(int index, T e) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("delete is failed , the index must>=0 or <= array.size");
        }

        if (size == data.length) {
            resize(2 * data.length);
        }

        for (int i= size-1; i >= index; i--) {
            data[i+1] = data[i];
        }

        data[index] = e;
        size++;
    }

    private void resize(int size) {
        T[] newData = (T[]) new Object[size];
        for (int i=0; i< this.size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    public void addFirst(T e) {
        add(0, e);
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();

        res.append(String.format("Array size=%d,capacity=%d", size, data.length));
        res.append("[");

        for (int i=0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(",");
            }
        }
        res.append("]");
        return res.toString();

    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed, Index is illegal ");
        }

        return data[index];
    }

    public T getLast() {
        return get(size - 1);
    }

    public T getFirst() {
        return  get(0);
    }

    public void set(int index, T e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed, Index is illegal ");
        }

        data[index] = e;
    }

    //数组中是否含有元素e
    public boolean contains(T e) {
        for (int i=0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    //在数组中查找元素的索引
    public int find(T e) {

        for (int i=0; i<size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }

        return -1;
    }

    public T remove(int index) {

        if (index < 0 || index >= size) {
            //IllegalArgumentException是一个非受查异常，所以是不用声明的
            throw new IllegalArgumentException("delete is failed , the index must>=0 or <= array.size");
        }

        T ret = data[index];

        for (int i=index+1; i<size; i++) {
            data[i-1] = data[i];
        }

        size--;

        data[size] = null; //释放最后一个所指向的对象，被垃圾回收

        if (size == data.length / 4 && data.length / 2 != 0 ) {
            resize(data.length/2);
        }

        return ret;
    }

    public T removeFirst() {
        return remove(0);
    }

    public T removeLast() {
        return remove(size-1);
    }

    public void removeElement(T e) {

        int index = find(e);

        if (index != -1) {
            remove(index);
        }

    }
}
