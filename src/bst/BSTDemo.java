package bst;

public class BSTDemo {

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();

        int[] arr = {8, 9, 12, 6, 4, 7};

        for (int i : arr) {
            bst.add(i);
        }

        bst.preOder();
        System.out.println();
        bst.inOrder();

    }

}


