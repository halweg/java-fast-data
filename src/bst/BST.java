package bst;

import jdk.dynalink.NamedOperation;

public class BST<E extends Comparable<E>> {

    private class Node {
        public E e;
        public Node left,right;

        public Node(E e) {
            this.e = e;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int getSize () {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        /*if (root == null) {
            root = new Node(e);
            size++;
        } else {
             add(root, e);
        }*/
        root = add(root, e);
    }

    private Node add(Node node, E e) {
        /*if (e.equals(node.e)) {
            return;
        } else if (e.compareTo(node.e) < 0 && node.left != null) {
            node.left = new Node(e);
            size++;
            return;
        } else if (e.compareTo(node.e) > 0 && node.right != null) {
            node.right = new Node(e);
            size++;
            return;
        }

        if (e.compareTo(node.e) < 0)  {
            add(node.left, e);
        } else {
            add(node.right, e);
        }*/
        if (node == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }

        return node;
    }

    public boolean contains(E e ) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {

        if (node == null) {
            return false;
        }

        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }

    }

    //前序遍历
    public void preOder() {
        preOder(root);
    }

    private void preOder(Node node) {
        if (node == null) {
            return;
        }

        System.out.println(node.e);

        preOder(node.left);
        preOder(node.right);
    }

    //中序遍历
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    //后序遍历
    public void backOrder() {
        backOrder(root);
    }

    private void backOrder(Node node) {
        if (node == null) {
            return;
        }
        backOrder(node.left);
        backOrder(node.right);
        System.out.println(node.e);
    }


}
