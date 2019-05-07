import collection.ThreadsQueue;
import dto.BookingRequest;
import threads.Consumer;
import threads.Producer;

import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        ThreadsQueue<BookingRequest> requestThreadsQueue = new ThreadsQueue<>(5);

        IntStream.range(0, 3).forEach(i -> new Producer(requestThreadsQueue).start());
        Thread.sleep(1000);
        IntStream.range(0, 6).forEach(i -> new Consumer(requestThreadsQueue).start());

    }
}
