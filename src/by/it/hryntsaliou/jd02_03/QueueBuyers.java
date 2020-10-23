package by.it.hryntsaliou.jd02_03;

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
            throw new RuntimeException(e);
        }
    }

    static Buyer extract() {
        synchronized (QUEUE) {
            return QUEUE.pollFirst();
        }
    }

    public static int getQueueSize() {
        return QUEUE.size();
    }


}
