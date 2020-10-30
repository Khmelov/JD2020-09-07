package by.it.kulik.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Market {


    public static void main(String[] args) {
        System.out.println("Market opened");
        int number = 0;
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier(i);
            threadPool.execute(cashier);
        }
        threadPool.shutdown();
        while (Manager.shopOpened()) {
            int countBuyer = Helper.getRandom(2);
            for (int i = 0; Manager.shopOpened() &&
                    i <= countBuyer; i++) {
                Buyer buyer = new Buyer(++number);
                buyer.start();
                Dispatcher.BUYERS_IN_SHOP++;
            }
            Helper.mySleep(1000);
        }
        try {
            while(threadPool.awaitTermination(1, TimeUnit.SECONDS)){

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Market closed");
    }
}
