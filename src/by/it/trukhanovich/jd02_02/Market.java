package by.it.trukhanovich.jd02_02;

import java.util.ArrayList;

public class Market {
    public static void main(String[] args) {
        MarketHelper marketHelper = new MarketHelper();
        marketHelper.getGoodToPrice();
        System.out.println("Market opened");
        int number=0;
        ArrayList<Thread> threads=new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Cashier cashier = new Cashier(i);
            Thread threadCashier = new Thread(cashier);
            threadCashier.start();
            threads.add(threadCashier);

        }

        for (;;){
            int countBuyer=Helper.getRandom(2);
            for (int j = 0; j < countBuyer&& Dispatcher.marketIsOpenedForNewBuyer(); j++) {
                Buyer buyer=new Buyer(++number);
                buyer.start();
                threads.add(buyer);
            }
            if (!Dispatcher.marketIsOpenedForNewBuyer()) {
                break;
            }
            Helper.mySleep(1000);

        }

        for (Thread th : threads) {
            try {
                th.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Market closed");

    }
}
