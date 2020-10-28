package by.it.stefankin.jd02_02;

import java.util.ArrayList;

public class Market {
    static ArrayList<Thread> threads = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Market  is opened");
        CashAdmin cashAdmin=new CashAdmin();
        Thread thread1 = new Thread(cashAdmin);
        thread1.start();
        threads.add(thread1);
        int number = 0;
        for (; ; ) {
            int countBuyer = Helper.getRandom(2);
            for (int i = 0; i < countBuyer && Dispatcher.marketIsOpenedForNewBuyer(); i++) {
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

        System.out.println("Market is closed");
    }
}
