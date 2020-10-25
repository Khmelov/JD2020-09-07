package by.it.yatsevich.jd02_02;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueueBuyers {

    static final Deque<Buyer> DEQUE_BUYERS = new ArrayDeque<>();

    static synchronized void add(Buyer buyer){
        DEQUE_BUYERS.addLast(buyer);
    }
    static synchronized int getLength(){
        int length=0;
        for (Buyer buyer : DEQUE_BUYERS) {
            length++;
        }
        return length;
    }
    static synchronized Buyer get(){
        return DEQUE_BUYERS.pollFirst();
    }
}
