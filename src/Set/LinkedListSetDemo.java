package Set;

public class LinkedListSetDemo {

    public static void main(String[] args) {

        int i2 = 0;

        LinkedListSet<Integer> set = new LinkedListSet<Integer>();

        for (int i = 1; i <=5; i ++) {
            set.add(i);
        }

        for (int i = 3; i <= 9; i++) {
            set.add(i);
        }

        System.out.println(set);
    }

}
