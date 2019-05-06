package threads;

import collection.ThreadsQueue;
import dto.BookingRequest;

public class Consumer extends Thread {

    private ThreadsQueue<BookingRequest> queue;

    public Consumer(ThreadsQueue<BookingRequest> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
                BookingRequest bookingRequest = queue.removeFirst();
                System.out.println("Booker " + this.getId() + " received:\n" + bookingRequest.toString());
                Thread.sleep(5000);
                System.out.println("Booker " + this.getId() + " processed:\n" + bookingRequest.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
