package threads;

import collection.ThreadsQueue;
import dto.BookingRequest;
import org.apache.log4j.Logger;
import util.RequestGenerator;

import java.util.concurrent.atomic.AtomicInteger;

public class Producer extends Thread {

    private static final int TOTAL_REQUESTS = 20;
    private static AtomicInteger requestCounter = new AtomicInteger(0);

    private Logger logger = Logger.getLogger(Producer.class);

    private ThreadsQueue<BookingRequest> queue;

    public Producer(ThreadsQueue<BookingRequest> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            while (requestCounter.getAndIncrement() < TOTAL_REQUESTS) {
                BookingRequest bookingRequest = RequestGenerator.generateRequest(requestCounter.get());
                queue.add(bookingRequest);
                logger.info("Producer " + this.getName() + " send:      " + bookingRequest.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
