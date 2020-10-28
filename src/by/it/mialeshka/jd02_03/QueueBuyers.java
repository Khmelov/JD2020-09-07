package by.it.mialeshka.jd02_03;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

class QueueBuyers {
    private static final BlockingQueue<Buyer> deque = new PriorityBlockingQueue<>(30);

    static void add(Buyer buyer){
        try {
            deque.put(buyer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static Buyer extract(){
        return deque.poll();
    }

    static int size(){
        return deque.size();
    }
}
