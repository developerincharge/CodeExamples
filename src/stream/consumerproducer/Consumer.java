package stream.consumerproducer;

import java.util.concurrent.BlockingQueue;

public class Consumer extends Thread{

    private BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue){
        this.queue = queue;
    }
    @Override
    public void run() {

        try {
             while(true){

                Integer value = queue.take();
                System.out.println("Consumed  : " + value);
                if(value == -1) {
                    System.out.println("Consumer Stopping____");
                    break;
                }
                 Thread.sleep(500);
            }

        }
        catch(Exception e) {
            Thread.currentThread().interrupt();
        }
    }

}
