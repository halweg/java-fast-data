package queue;

public class ArrayQueueDemo {

    public static void main(String[] args) {
        ArrayQueue<Integer> q = new ArrayQueue<>(10);

        for (int i = 0; i <= 100; i++ ) {
            System.out.println(q.toString());
            q.enqueue(i);
        }
        System.out.println(q.toString());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());

        System.out.println(q.toString());

    }
}
