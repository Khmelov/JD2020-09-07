package by.it.drugov.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Store {
    public static void main(String[] args) {
        Dispatcher dispatcher = new Dispatcher(100);
        System.out.println("Store is open!");
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier(i,dispatcher);
            executorService.execute(cashier);
        }
        executorService.shutdown();
        int number = 0;
        for (; ; ) {
            for (int j = 0; j < Helper.getRandom(0, 2) && dispatcher.marketIsOpenedForNewBuyer(); j++) {
                Buyer buyer = new Buyer(++number,dispatcher);
                buyer.start();
            }
            if (!dispatcher.marketIsOpenedForNewBuyer())
                break;
            Helper.mySleep(1000);
        }

        try {
            //noinspection StatementWithEmptyBody
            while (!executorService.awaitTermination(3, TimeUnit.HOURS)){
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Store is closed!");
    }
}
