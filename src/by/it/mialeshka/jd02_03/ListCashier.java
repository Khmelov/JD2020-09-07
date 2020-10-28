package by.it.mialeshka.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

class ListCashier {
    private static final BlockingDeque<Cashier> cashiers = new LinkedBlockingDeque<>();
    static void add(Cashier cashier){
        try {
            cashiers.putLast(cashier);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    static Cashier extract(){
        return cashiers.pollFirst();
    }

    static int size(){
        return cashiers.size();
    }




}
