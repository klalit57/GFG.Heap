package GFG;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq= new PriorityQueue<Integer>(); //minHeap by default

        pq.add(10);
        pq.add(20);
        pq.add(15);
        System.out.println(pq.peek());
        System.out.println(pq.poll());
        System.out.println(pq.peek());

        PriorityQueue<Integer> pq2= new PriorityQueue<Integer>(Collections.reverseOrder());
        pq2.add(10);
        pq2.add(20);
        pq2.add(15);
        System.out.println(pq2.peek());
        System.out.println(pq2.poll());
        System.out.println(pq2.peek());


    }
}
