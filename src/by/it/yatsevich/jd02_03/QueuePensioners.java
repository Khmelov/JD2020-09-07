package by.it.yatsevich.jd02_03;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueuePensioners {
    static final Deque<Buyer> DEQUE_PENSIONERS = new ArrayDeque<>();

    static synchronized void add(Buyer buyer){
        DEQUE_PENSIONERS.addLast(buyer);
    }

    static synchronized Buyer get(){
        return DEQUE_PENSIONERS.pollFirst();
    }
}
