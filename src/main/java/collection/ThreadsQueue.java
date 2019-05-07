package collection;

import java.util.Deque;
import java.util.LinkedList;


public class ThreadsQueue<E> {

    private Deque<E> queue = new LinkedList<>();
    private int capacity;

    public ThreadsQueue(int capacity) {
        this.capacity = capacity;
    }

    public boolean notEmpty () {
        return !queue.isEmpty();
    }

    public synchronized void add(E element) throws InterruptedException {
        while (queue.size() == capacity) {
            wait();
        }
        queue.add(element);
        notifyAll();
    }

    public synchronized E removeFirst() throws InterruptedException {
        while (queue.size() == 0) {
            wait();
        }
        notifyAll();
        return queue.removeFirst();
    }

}
