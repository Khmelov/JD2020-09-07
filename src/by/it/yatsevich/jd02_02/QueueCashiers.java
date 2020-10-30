package by.it.yatsevich.jd02_02;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueueCashiers {

    static final Deque<Cashier> DEQUE_CASHIERS = new ArrayDeque<>();

    static synchronized void add(Cashier cashier){
        DEQUE_CASHIERS.addLast(cashier);
    }

    static synchronized Cashier get(){
        return DEQUE_CASHIERS.pollFirst();
    }
}
