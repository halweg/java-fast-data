package queue;

public class LoopQueueDemo {

    public static void main(String[] args) {
        LoopQueue<Integer> q = new LoopQueue<>(10);

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
