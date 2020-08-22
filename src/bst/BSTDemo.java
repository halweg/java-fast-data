package bst;

public class BSTDemo {

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();

        int[] arr = {8, 9, 12, 6, 4, 7};

        for (int i : arr) {
            bst.add(i);
        }
        //bst.preOd er();
        //bst.preOrderNR();
        System.out.println();
        //bst.levelOrder();
        //bst.removeMax();
        //bst.removeMin();
        //System.out.println(bst.maxmum());
        bst.remove(8);
        bst.preOder();
        //bst.inOrder();

    }

}


