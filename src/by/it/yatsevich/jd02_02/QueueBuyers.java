package by.it.yatsevich.jd02_02;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueueBuyers {
    static volatile int BUYERS_IN_QUEUE = 0;
    static final Deque<Buyer> DEQUE_BUYERS = new ArrayDeque<>();

    static synchronized void add(Buyer buyer){
        DEQUE_BUYERS.addLast(buyer);
    }

    static synchronized Buyer get(){
        return DEQUE_BUYERS.pollFirst();
    }
}
