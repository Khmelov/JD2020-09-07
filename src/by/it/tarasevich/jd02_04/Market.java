package by.it.tarasevich.jd02_04;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Market {


    public static void main(String[] args) {
        Dispatcher dispatcher = new Dispatcher(200);
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
            for (int i = 0; i < countBuyer && dispatcher.marketIsOpenForNewBuyer(); i++) {
                Buyer buyer = new Buyer(++number, dispatcher);
                buyer.start();

            }
            if (!dispatcher.marketIsOpenForNewBuyer())
                break;
            Helper.mySleep(1000);
        }

        try {
            while (!executorService.awaitTermination(10, TimeUnit.DAYS)) {

            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }



        System.out.println("Market closed");
    }
}
