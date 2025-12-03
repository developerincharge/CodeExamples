package array;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.offer(20);
        queue.offer(30);
        queue.add(40);

        System.out.println("Queue after additions  "+queue);

        System.out.println("Front element :"+queue.peek());
        int removedElement = queue.poll();
        System.out.println("Front Element :"+removedElement);

        System.out.println("Queue after additions: "+queue);
        System.out.println("Last Element : "+ (long) queue.size());

    }

}
