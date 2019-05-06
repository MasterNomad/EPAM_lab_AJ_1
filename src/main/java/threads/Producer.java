package threads;

import collection.ThreadsQueue;
import dto.BookingRequest;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer extends Thread {

    private static final List<String> HOTEL_NAMES = Arrays.asList("Abu Dhabi", "Rancho Valencia Resort",
            "The Westin Excelsior", "Burj Al Arab Hotel", "The Plaza", "Atlantis Paradise Island,");

    private static AtomicInteger requestCounter = new AtomicInteger(0);
    private ThreadsQueue<BookingRequest> queue;

    private static int totalRequests = 15;

    public Producer(ThreadsQueue<BookingRequest> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            while (requestCounter.get() < totalRequests) {
                BookingRequest bookingRequest = generateRequest();
                queue.add(bookingRequest);
                System.out.println("Producer " + this.getId() + " send:\n" + bookingRequest.toString());
                requestCounter.incrementAndGet();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private BookingRequest generateRequest() {
        Random random = new Random();
        BookingRequest bookingRequest = new BookingRequest();
        bookingRequest.setHotel(HOTEL_NAMES.get(random.nextInt(HOTEL_NAMES.size() - 1)));
        bookingRequest.setEntryDate(LocalDate.now().plusDays(random.nextInt(20)));
        bookingRequest.setPersonsNumber(random.nextInt(4) + 1);
        return bookingRequest;
    }

    public static void setTotalRequests(int totalRequests) {
        Producer.totalRequests = totalRequests;
    }
}
