package by.it.kulik.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Market {


    public static void main(String[] args) {
        System.out.println("Market opened");
        int number = 0;
        List<Thread> threads = new ArrayList<>();
        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier(i);
            Thread thread = new Thread(cashier);
            threads.add(thread);
            thread.start();
        }
        while (Manager.shopOpened()) {
            int countBuyer = Helper.getRandom(2);
            for (int i = 0; Manager.shopOpened() &&
                    i <= countBuyer; i++) {
                Buyer buyer = new Buyer(++number);
                buyer.start();
                threads.add(buyer);
                Dispatcher.BUYERS_IN_SHOP++;
            }
            Helper.mySleep(1000);
        }
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Market closed");
    }
}
