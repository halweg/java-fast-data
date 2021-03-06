package queue;

import com.sun.nio.sctp.SctpStandardSocketOptions;

import java.util.Random;

public class CampareQueue {

    public static double queueTest(Queue q, int opcount) {

        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opcount; i++ ) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }

        for (int i = 0; i < opcount; i++) {
            q.dequeue();
        }


        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int opcount = 50000;

        ArrayQueue<Integer> arr = new ArrayQueue<>();

        double spendTime = queueTest(arr, opcount);

        LoopQueue<Integer> loop = new LoopQueue<>();

        double spendTime2 = queueTest(loop, opcount);

        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();

        double spendTime3 = queueTest(linkedListQueue, opcount);

        System.out.println(opcount+"次入队出队，普通队列消耗："+ spendTime + "s");
        System.out.println(opcount+"次入队出队，循环队列消耗："+ spendTime2 + "s");
        System.out.println(opcount+"次入队出队，链表队列消耗："+ spendTime3 + "s");

    }

}
