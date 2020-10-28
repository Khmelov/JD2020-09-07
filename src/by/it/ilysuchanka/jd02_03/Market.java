package by.it.ilysuchanka.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Market {

    public static void main(String[] args) {
        Dispatcher dispatcher = new Dispatcher(100);
        System.out.println("Market opened");
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier(i, dispatcher);
            executorService.execute(cashier);
        }
        executorService.shutdown();

        int number = 0;
        for (; ; ) {
            int countBuyer = Helper.getRandom(2);
            for (int i = 0; i < countBuyer && dispatcher.marketIsOpenedForNewBuyer(); i++) {
                Buyer buyer = new Buyer(++number, dispatcher);
                buyer.start();
            }
            if (!dispatcher.marketIsOpenedForNewBuyer())
                break;
            Helper.mySleep(1000);
        }
        try {
            while (!executorService.awaitTermination(12, TimeUnit.HOURS)){

            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Market closed");
    }
}
