package by.it.yatsevich.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

public class QueueBuyers {
    static AtomicInteger BUYERS_IN_QUEUE = new AtomicInteger(0);
    static final BlockingDeque<Buyer> DEQUE_BUYERS = new LinkedBlockingDeque<>(30);

    static void add(Buyer buyer){
        try {
            DEQUE_BUYERS.putLast(buyer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static Buyer get(){
        return DEQUE_BUYERS.pollFirst();
    }
}
