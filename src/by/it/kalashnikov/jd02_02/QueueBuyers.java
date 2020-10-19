package by.it.kalashnikov.jd02_02;

import java.util.ArrayDeque;
import java.util.Deque;

class QueueBuyers {
    private QueueBuyers() {
    }

    private final static Deque<Buyer> QUEUE = new ArrayDeque<>();

    static void add(Buyer buyer) {
        synchronized (QUEUE) {
            QUEUE.addLast(buyer);
        }
    }

    static Buyer extract() {
        synchronized (QUEUE) {
            return QUEUE.pollFirst();
        }

    }
}
