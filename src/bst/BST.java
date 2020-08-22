package bst;

import jdk.dynalink.NamedOperation;
import queue.LinkedListQueue;
import stack.LinkedListStack;

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

    //前顺遍历，非递归方式
    public void preOrderNR() {

        LinkedListStack<Node> stack = new LinkedListStack<>();

        stack.push(root);

        while (!stack.isEmpty()) {
            Node cur = stack.pop();

            System.out.println(cur.e);

            if (cur.right != null) {
                stack.push(cur.right);
            }

            if (cur.left != null) {
                stack.push(cur.left);
            }
        }

    }

    //广度优先遍历
    public void levelOrder()
    {
        LinkedListQueue<Node> queue = new LinkedListQueue<>();

        queue.enqueue(root);

        while (!queue.isEmpty()) {

            Node cur = queue.dequeue();

            System.out.println(cur.e);

            if (cur.left != null) {
                queue.enqueue(cur.left);
            }

            if (cur.right != null) {
                queue.enqueue(cur.right);
            }

        }

    }

    //返回BST的最小节点
    public E minimum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }
        return minimum(root).e;
    }
    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    //返回BST的最大节点
    public E maxmum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }
        return maximum(root).e;
    }
    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }

        return maximum(node.right);
    }

    //删除BST中的最小值
    public E removeMin() {
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }
    private Node removeMin(Node node) {

        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    //删除二分搜索树最大的元素
    public E removeMax() {
        E ret = maxmum();
        root = removeMax(root);
        return ret;
    }
    private Node removeMax(Node node) {

        if (node.right == null) {
            Node nodeLeft = node.left;
            node.left = null;
            size--;
            return nodeLeft;
        }

        node.right = removeMax(node.right);
        return node;
    }

    //删除二分搜索树中任意一个元素
    public void remove(E e) {
        root = remove(e, root);
    }

    private Node remove(E e,Node node) {

        if (node == null) {
            return node;
        }

        if (e.compareTo(node.e) < 0) {
            node.left = remove(e, node.left);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(e, node.right);
            return node;
        } else  {
            //开始删除

            if (node.left == null) {
                Node rightNode = node.right;
                size --;
                node.right = null;
                return rightNode;
            }
            if (node.right == null) {
                Node leftNode = node.left;
                size --;
                node.left = null;
                return leftNode;

            }
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = null;
            node.right = null;
            return successor;
        }


    }


}
