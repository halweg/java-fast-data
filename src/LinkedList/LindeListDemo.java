package LinkedList;

public class LindeListDemo {

    public static void main(String[] args) {

        LinkedList<Integer> l = new LinkedList<Integer>();

        for (int i = 0; i <5; i++) {
            l.addLast(i);
        }

        System.out.println(l.toString());

        //l.add(2, 666);

        //System.out.println(l.toString());

        //l.addLast(77777);

        //System.out.println(l.toString());

        l.remove(0);

        System.out.println(l.toString());
    }

}
