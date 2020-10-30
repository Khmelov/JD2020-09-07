package by.it.yatsevich.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Market {
    public static void main(String[] args) {
        System.out.println("##Market open##");
        int number=0;
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 5; i++) {
            Cashier cashier = new Cashier(i);
            service.execute(cashier);
        }
        service.shutdown();

        Thread threadMan=new Thread(new CashierManager());
        threadMan.setDaemon(true);
        threadMan.start();


        while (Supervisor.shopOpened()){
            int time;
            int countBuyer= Helper.getRandom(2);
            for (time = 0; Supervisor.shopOpened()&& time < countBuyer; time++) {
                Buyer buyer=new Buyer(++number);
                    buyer.start();
                    Supervisor.BUYER_IN_THE_SHOP.getAndIncrement();
            }
            Helper.sleep(1000);
        }

        try {
                while (!service.awaitTermination(1, TimeUnit.SECONDS)){
                    System.out.println("!!Market still worked!!");
                }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("##Market closed##");
    }

    private static int getCountBuyers(int time) {

        int value = 0;
        int modifier = 0;
        if (time > 60)
            modifier = 60;
        if (time == 1) value = 10;
        if (time <= 30 || time > 60 && time <= 90) value = 10 + time-modifier - Supervisor.BUYER_IN_THE_SHOP.get();
        if (time > 30 && time <= 60 || time > 90) {
            if (Supervisor.BUYER_IN_THE_SHOP.get() <= 40 + (30 - time + modifier)) {
                value = 40 + (30 - time + modifier) - Supervisor.BUYER_IN_THE_SHOP.get();
            }
        }


        return value;
    }
}
