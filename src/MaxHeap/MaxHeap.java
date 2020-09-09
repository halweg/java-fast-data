package MaxHeap;

public class MaxHeap<E extends Comparable<E>> {



    private Array<E> data;

    public MaxHeap (int capacity) {
        data = new Array<E>(capacity);
    }

    public MaxHeap () {
        data = new Array<E>();
    }

    public int getSize() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index 0-1 have not parent");
        }
        return (index - 1) / 2;
    }

    private int leftChild(int index) {

        return index * 2 + 1;
    }

    private int rightChild(int index) {
        return index * 2 + 2;
    }

    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int k) {
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k))   < 0 ) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    public E findMax() {
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("Cant not get max ,the heap is null");

        }
        return data.get(0);
    }

    //取出堆中最大的元素
    public E extractMax() {
        E ret = findMax();

        data.swap(0, data.getSize() - 1);

        data.removeLast();

        siftDown(0);

        return ret;
    }

    private void siftDown(int k) {

        //k节点若有子节点，子节点最小的key应该为 leftChild（K）
        //k的子节点最小的key应该小于data整体的size,此时k的子节点方才存在
        while (leftChild(k) < data.getSize()) {

            int j  = leftChild(k);
            if (j + 1 < data.getSize() &&
                    data.get(j+1).compareTo(data.get(j)) > 0 ) {
                j = rightChild(k);
                //此时 data[j] 是rightChild 和 leftChild 中的最大值

                if (data.get(k).compareTo(data.get(j)) > 0) {
                    break;
                }

                data.swap(k, j);

                k = j;

            }

        }
    }

    //从堆中取出最大的元素，并且把它替换成e
    public E replace(E e) {
        E ret = findMax();

        data.set(0, e);

        siftDown(0);

        return ret;
    }


}
