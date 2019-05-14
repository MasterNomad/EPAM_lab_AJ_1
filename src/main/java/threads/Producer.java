package threads;

import collection.ThreadsQueue;
import dto.BookingRequest;
import org.apache.log4j.Logger;
import util.RequestGenerator;

import java.util.concurrent.atomic.AtomicInteger;

public class Producer extends Thread {

    private static AtomicInteger requestCounter = new AtomicInteger(0);
    private static Logger logger = Logger.getLogger(Producer.class);

    private ThreadsQueue<BookingRequest> queue;

    public Producer(ThreadsQueue<BookingRequest> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            BookingRequest bookingRequest = RequestGenerator.generateRequest(requestCounter.getAndIncrement());
            queue.add(bookingRequest);
            logger.info("Producer " + this.getName() + " send:      " + bookingRequest.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
