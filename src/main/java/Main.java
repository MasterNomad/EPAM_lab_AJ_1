import collection.ThreadsQueue;
import dto.BookingRequest;
import threads.Consumer;
import threads.Producer;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        ThreadsQueue <BookingRequest> requestThreadsQueue = new ThreadsQueue<>(5);

        new Producer(requestThreadsQueue).start();
        new Producer(requestThreadsQueue).start();
        new Producer(requestThreadsQueue).start();

        Thread.sleep(1000);

        new Consumer(requestThreadsQueue).start();
        new Consumer(requestThreadsQueue).start();
        new Consumer(requestThreadsQueue).start();
        new Consumer(requestThreadsQueue).start();
        new Consumer(requestThreadsQueue).start();
        new Consumer(requestThreadsQueue).start();
    }
}
