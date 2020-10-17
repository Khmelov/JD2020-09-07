package by.it.trukhanovich.jd02_02;

import java.util.ArrayList;

public class Market {
    static ThreadGroup cashiers=new ThreadGroup("Группа потоков cashier");

    public static void main(String[] args) {
        MarketHelper marketHelper = new MarketHelper();
        marketHelper.getGoodToPrice();
        System.out.println("Market opened");
        int number=0;
        ArrayList<Thread> threads=new ArrayList<>();
//        ThreadGroup cashiers=new ThreadGroup("Группа потоков cashier");
        for (int i = 1; i <= 5; i++) {
            Cashier cashier = new Cashier(i);
            Thread threadCashier = new Thread(cashiers,cashier);
            threadCashier.start();
            threads.add(threadCashier);
        }
        Manager manager = new Manager("Manager");
        Thread threadManager = new Thread(manager);
        threadManager.setDaemon(true);
        threadManager.start();

        StringBuilder coutnThread= new StringBuilder();
        int second=0;
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
//            coutnThread.append("На секунде "+ second +" работало кассиров "
//                    +cashiers.activeCount()+". Размер очереди "
//                    +QueueBuyers.getSizeQUEUE()+"\n");

            second++;
        }

        for (Thread th : threads) {
            try {
                th.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Market closed");
        System.out.println(coutnThread);
    }
}
