package MaxHeap;

import jdk.jshell.execution.Util;

import java.nio.charset.IllegalCharsetNameException;
import java.util.Random;

public class MaxHeapDemo {

    static double testManHeap(Integer[] arr, boolean isHeapify) {

        long startTime = System.nanoTime();

        MaxHeap<Integer> maxHeap;

        if (isHeapify) {
            maxHeap = new MaxHeap<Integer>(arr);
        } else {
            maxHeap = new MaxHeap<Integer>();
            for (Integer num : arr) {
                maxHeap.add(num);
            }
        }

        int[] arri = new int[arr.length];

        for (int i=0; i<arr.length; i++) {
            arri[i] = maxHeap.extractMax();
        }

        for (int i=1; i<arr.length; i++) {
            //System.out.println(arr[i]);
            if (arri[i-1] < arri[i]) {
                throw new IllegalArgumentException("heap is error");
            }
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;

    }

    public static void main(String[] args) {

        Integer[] testData = new Integer[1000000];

        Random random = new Random();

        for (int i=0; i < testData.length; i++) {
            testData[i] = random.nextInt(Integer.MAX_VALUE);
        }

        double time1 = testManHeap(testData, false);

        System.out.println("不使用heapify创建堆耗时："+ time1);

        double time2 = testManHeap(testData, true);

        System.out.println("使用heapify创建堆耗时："+ time2);

    }

}
