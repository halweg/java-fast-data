package Set;

import bst.BST;

public class BSTSet<E extends Comparable<E>> implements Set<E> {

    private BST bst;

    public BSTSet() {
        bst = new BST();
    }

    public void add(E e) {
        bst.add(e);
    }

    public void remove(E e) {
        bst.remove(e);
    }

    public boolean contains(E e) {
        return bst.contains(e);
    }

    public boolean isEmpty() {

        return bst.isEmpty();
    }

    public int getSize() {
        return bst.getSize();
    }

}
