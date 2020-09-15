package MaxHeap;

import java.util.spi.AbstractResourceBundleProvider;

public class MaxHeap<E extends Comparable<E>> {



    private Array<E> data;

    public MaxHeap (int capacity) {
        data = new Array<E>(capacity);
    }

    public MaxHeap () {
        data = new Array<E>();
    }

    public MaxHeap(E[] arr) {
        data = new Array<E>(arr);
        for (int i= parent(data.getSize() - 1); i >= 0; i--) {
            siftDown(i);
        }
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
        //k节点若有子节点，子节点最小的key应该为 leftChild（K）,左子节点的index应该不大于data的尺寸
        while (leftChild(k) < data.getSize()) {
            //System.out.println("siftDown while 中。。。。。");
            int j  = leftChild(k);
            if (j + 1 < data.getSize() &&
                    data.get(j+1).compareTo(data.get(j)) > 0 ) {
                j = rightChild(k);
                //此时 data[j] 是rightChild 和 leftChild 中的最大值
            }
            if (data.get(k).compareTo(data.get(j)) >= 0) {
                break;
            }
            data.swap(k, j);
            k = j;
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
