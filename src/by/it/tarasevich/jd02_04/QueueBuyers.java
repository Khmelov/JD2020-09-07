package by.it.tarasevich.jd02_04;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;


public class QueueBuyers {

    public QueueBuyers() {
    }

    private final static BlockingDeque<Buyer> QUEUE = new LinkedBlockingDeque<>(30);

     static void add(Buyer buyer) {
         try {
             QUEUE.putLast(buyer);
         }catch (InterruptedException e){
             throw new RuntimeException(e);
         }
    }
    static Buyer extract(){

             return QUEUE.pollFirst();

    }
}
