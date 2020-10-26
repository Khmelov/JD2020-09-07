package by.it.mialeshka.jd02_02;

import java.util.ArrayDeque;
import java.util.Deque;

class ListCashier {
    private static final Deque<Cashier> cashiers = new ArrayDeque<>();
    static synchronized void add(Cashier cashier){
        cashiers.add(cashier);
    }
    static synchronized Cashier extract(){
        return cashiers.pollFirst();
    }

    static synchronized int size(){
        return cashiers.size();
    }


}
