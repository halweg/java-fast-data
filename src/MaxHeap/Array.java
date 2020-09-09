package MaxHeap;

public class Array<T> extends array.Array<T> {


    public Array(int capacity){
       super(capacity);
    }

    public Array() {
        super();
    }

    public void swap(int i, int j) {
        if (i < 0 || i >= getSize() || j < 0 || j >= getSize())
            throw new IllegalArgumentException("Illegal index");
        T tmp = get(i);
        set(i, get(j));
        set(j, tmp);
    }

}
