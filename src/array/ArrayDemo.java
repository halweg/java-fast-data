package array;

public class ArrayDemo {
    public static void main(String[] args) {
        Array<Integer> arr = new Array<>(10);
        System.out.println(arr.toString());

        for (int i = 0; i<14; i++) {
            arr.addLast(i);
        }
        arr.add(1, 9090);
        arr.add(0, -1);

        System.out.println(arr.toString());

        for (int i = 0; i<=6; i++) {
            arr.remove(i);
        }


        System.out.println(arr.toString());
    }
}
