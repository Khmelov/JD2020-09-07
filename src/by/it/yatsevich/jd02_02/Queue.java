package by.it.yatsevich.jd02_02;

import java.util.ArrayDeque;
import java.util.Deque;

public class Queue {
    private static Deque<Buyer> deque = new ArrayDeque<>();

    static synchronized void add(Buyer buyer){
        deque.add(buyer);
    }
    static synchronized Buyer get(){
        return deque.pollFirst();
    }
}
