package by.it.stefankin.jd02_02;

import java.util.ArrayDeque;
import java.util.Deque;

public class SubQfCash {

    private SubQfCash () {
    }

    private final static Deque<Cashier> QUEUE1 = new ArrayDeque<>();

    static void add(Cashier cashier) {
        synchronized (QUEUE1) {
            QUEUE1.addLast(cashier);
        }
    }

    static Cashier extract() {
        synchronized (QUEUE1) {
            System.out.println("1111111111111111EXTRACT");
            return QUEUE1.pollFirst();

        }


    }
    static boolean isEmpty() {

        return QUEUE1.isEmpty();
    }


    static int getSubQueueSize() {
        synchronized (QUEUE1) {
            return QUEUE1.size();
        }

    }

}
