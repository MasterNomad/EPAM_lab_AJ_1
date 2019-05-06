package collection;

import java.util.LinkedList;
import java.util.List;


public class  ThreadsQueue<E> {

    private List<E> list = new LinkedList<>();
    private int capacity;

    public ThreadsQueue(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void add(E element) {
        try {
            while (list.size() == capacity) {
                wait();
            }
            list.add(element);
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized E removeFirst() {
        try {
            while (list.size() == 0) {
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        notifyAll();
        return list.remove(0);
    }

}
