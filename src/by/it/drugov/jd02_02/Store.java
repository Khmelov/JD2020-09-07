package by.it.drugov.jd02_02;

import java.util.ArrayList;

public class Store {
    public static void main(String[] args) {
        System.out.println("Store is open!");

        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier(i);
            Thread thread = new Thread(cashier);
            thread.start();
            threads.add(thread);
        }
        int number = 0;
        for (; ; ) {
            for (int j = 0; j < Helper.getRandom(0, 2) && Dispatcher.marketIsOpenedForNewBuyer(); j++) {
                Buyer buyer = new Buyer(++number);
                buyer.start();
                threads.add(buyer);
            }
            if (!Dispatcher.marketIsOpenedForNewBuyer())
                break;
            Helper.mySleep(1000);
        }

        for (Thread th : threads) {
            try {
                th.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Store is closed!");
    }
}
