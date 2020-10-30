package by.it.stefankin.jd02_03;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class QueueBuyers {


    private QueueBuyers() {
    }

    private final static BlockingDeque<Buyer> QUEUE = new LinkedBlockingDeque<>(30);

    static void add(Buyer buyer) {
        try {
            QUEUE.putLast(buyer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    static Buyer extract() {
        return QUEUE.pollFirst();
    }

    static int getNumber() {
        synchronized (QUEUE) {
            return QUEUE.size();
        }

    }
    static boolean isEmpty() {
        return QUEUE.isEmpty();
    }



}
