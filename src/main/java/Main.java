import collection.ThreadsQueue;
import dto.BookingRequest;
import threads.Consumer;
import threads.Producer;

public class Main {

    public static void main(String[] args) {

        ThreadsQueue <BookingRequest> requestThreadsQueue = new ThreadsQueue<>(5);
        Producer.setTotalRequests(15);

        new Producer(requestThreadsQueue).start();
        new Producer(requestThreadsQueue).start();
        new Producer(requestThreadsQueue).start();

        new Consumer(requestThreadsQueue).start();
        new Consumer(requestThreadsQueue).start();
        new Consumer(requestThreadsQueue).start();
        new Consumer(requestThreadsQueue).start();
        new Consumer(requestThreadsQueue).start();
        new Consumer(requestThreadsQueue).start();
    }
}
