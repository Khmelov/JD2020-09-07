package by.it.stefankin.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Market {



   public static void main(String[] args) {
        System.out.println("Market  is opened");
        ExecutorService threadPool = Executors.newFixedThreadPool(8);

         System.out.println("creates cashiers");

         for (int i = 1; i <= 2; i++) {
             Cashier cashier = new Cashier(i);
             threadPool.execute(cashier);
         }

           // CashAdmin cashAdmin = new CashAdmin();
           // threadPool.execute(cashAdmin);

           int number = 0;
           for (; ; ) {
               int countBuyer = Helper.getRandom(2);
               for (int f = 0; f < countBuyer && Dispatcher.marketIsOpenedForNewBuyer(); f++) {
                   Buyer buyer = new Buyer(++number);
                   buyer.start();

               }
               if (!Dispatcher.marketIsOpenedForNewBuyer())
                   break;
               Helper.mySleep(1000);
           }
           Helper.mySleep(2000);

           threadPool.shutdown();

           try {
               while (!threadPool.awaitTermination(1, TimeUnit.SECONDS))
                   System.out.println("it works yet");
           } catch (InterruptedException e) {
               e.printStackTrace();
           }

           System.out.println("Market is closed");
       }

}
