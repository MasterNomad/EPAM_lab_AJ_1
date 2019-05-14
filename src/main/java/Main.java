import collection.ThreadsQueue;
import dto.BookingRequest;
import threads.Consumer;
import threads.Producer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Main {

    private static final int PRODUCERS_AMOUNT = 3;
    private static final int OPERATIONS_AMOUNT = 15;

    public static void main(String[] args) throws InterruptedException {

        ThreadsQueue<BookingRequest> requestThreadsQueue = new ThreadsQueue<>(5);

        ExecutorService producerExecutor = Executors.newFixedThreadPool(PRODUCERS_AMOUNT);

        IntStream.range(0, OPERATIONS_AMOUNT).forEach(i -> producerExecutor.submit(new Producer(requestThreadsQueue)));
        Thread.sleep(1000);
        IntStream.range(0, 6).forEach(i -> new Consumer(requestThreadsQueue).start());

       producerExecutor.shutdown();
    }
}
