package by.it.mialeshka.jd02_02;

import java.util.ArrayDeque;
import java.util.Deque;

class QueueBuyers {
    private static final Deque<Buyer> deque = new ArrayDeque<>();
    private static final Deque<Buyer> dequePens = new ArrayDeque<>();

    static synchronized void add(Buyer buyer){
        if(!buyer.pensioneer)
            deque.add(buyer);
        else
            dequePens.add(buyer);
    }

    static synchronized Buyer extract(){
        if(dequePens.size() > 0)
            return dequePens.pollFirst();
        else
            return deque.pollFirst();
    }

    static synchronized int size(){
        return deque.size() + dequePens.size();
    }



}
