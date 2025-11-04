package stream.consumerproducer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerExample {

    public static void main(String[] args) {

        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

        Producer p = new Producer(queue, 10);
        Consumer c = new Consumer(queue);
        p.start();
        c.start();

    }
}
