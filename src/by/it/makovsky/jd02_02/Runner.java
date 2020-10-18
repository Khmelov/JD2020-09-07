package by.it.makovsky.jd02_02;

import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {
        System.out.println("Магазин открыт");
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier(i);
            Thread thread = new Thread(cashier);
            thread.start();
            threads.add(thread);
        }

        int number = 0;
        for (; ; ) {
            int countBuyer = Rnd.getRandom(2);
            for (int i = 0; i < countBuyer && Dispatcher.marketIsOpenedForNewBuyer(); i++) {
                Buyer buyer = new Buyer(++number);
                buyer.start();
                threads.add(buyer);
            }
            if (!Dispatcher.marketIsOpenedForNewBuyer())
                break;
            Rnd.mySleep(1000);
        }
        for (Thread th : threads) {
            try {
                th.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Магазин закрыт");
    }
}
