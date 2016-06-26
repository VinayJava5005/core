package concepts.collections;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by parya on 5/17/2016.
 */
public class QueueDemo {

    public static void main(String[] args) {
        Queue<Integer> linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        System.out.println(linkedList.add(3));
        System.out.println(linkedList.offer(3));

        System.out.println("LinkedList Queue Implementation : ");
        System.out.println(linkedList);

        System.out.println("Show First Element : " + linkedList.element());
        System.out.println("Remove First Element : " + linkedList.remove());
        System.out.println("Remove First Element : " + linkedList.poll());
        System.out.println("Updated Queue : " + linkedList);


        Queue<Integer> priorityQueue = new PriorityQueue();
        priorityQueue.add(1);
        priorityQueue.add(2);
        priorityQueue.add(3);
        priorityQueue.add(4);
        priorityQueue.add(5);
        priorityQueue.add(3);
        priorityQueue.offer(2);

        System.out.println(".....................................................");

        System.out.println("PriorityQueue Queue Implementation : ");
        System.out.println(priorityQueue);

        System.out.println("Show First Element : " + priorityQueue.element());
        System.out.println("Remove First Element : " + priorityQueue.remove());
        System.out.println("Updated Queue : " + priorityQueue);

        System.out.println("......................................................");
        System.out.println("Abnormal Conditions");
        Queue<Integer> queue = new PriorityQueue<>();
        System.out.println(queue.poll());


    }
}
