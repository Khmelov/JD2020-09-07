package by.it.mialeshka.jd02_03;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Shop {
    static List<Thread> threads = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Shop opened");
        int isP = 0;
        int nBuyer = 0;
        ExecutorService thredPool = Executors.newFixedThreadPool(6);
        Manager manager = new Manager();
        thredPool.execute(manager);

        for (int i = 1; i <= Dispatcher.PLAN_CASHIER; i++) {
            Cashier cashier = new Cashier(i);
            thredPool.execute(cashier);
        }
        thredPool.shutdown();

        for (int i = 1; i <= Dispatcher.PLAN_CASHIER; i++) {
            Cashier cashier = new Cashier(i);
            Thread thread = new Thread(cashier);
            threads.add(thread);
            thread.start();
        }

        while (Dispatcher.shopOpened()){
            for (int i = 1; i <= 60; i++) {
                int count = getCountBuyers(i);
                for (int j = 1; j <= count && Dispatcher.shopOpened(); j++) {
                    isP++;
                    Buyer byer;
                    if (isP % 4 == 0) byer = new Buyer(++nBuyer, true);
                    else byer = new Buyer(++nBuyer, false);
                    byer.start();
                    threads.add(byer);
                }
                Helper.sleep(1000);
            }
        }

        try {
            while(!thredPool.awaitTermination(1, TimeUnit.SECONDS))  { }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Shop closed");
    }

    private static int getCountBuyers(int time) {
        int res;
        int countActive;
        countActive = Dispatcher.IN_COUNT.get() - Dispatcher.OUT_COUNT.get();

        if (time == 1)
            return 10;

        if (time < 30) {
            return time+10-countActive;
        }
        else{
            return  40+30-time - countActive;
        }
    }
}
