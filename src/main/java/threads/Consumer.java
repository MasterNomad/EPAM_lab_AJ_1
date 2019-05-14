package threads;

import collection.ThreadsQueue;
import dto.BookingRequest;
import org.apache.log4j.Logger;

public class Consumer extends Thread {


    private final static int SLEEP_TIME = 1000;
    private static Logger logger = Logger.getLogger(Consumer.class);

    private ThreadsQueue<BookingRequest> queue;

    public Consumer(ThreadsQueue<BookingRequest> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            while (queue.notEmpty()) {
                BookingRequest bookingRequest = queue.removeFirst();
                logger.info("Consumer " + this.getName() + " received:  " + bookingRequest.toString());
                Thread.sleep(SLEEP_TIME);
                logger.info("Consumer " + this.getName() + " processed: " + bookingRequest.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
