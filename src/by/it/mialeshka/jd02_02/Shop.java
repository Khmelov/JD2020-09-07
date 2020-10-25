package by.it.mialeshka.jd02_02;


import java.util.ArrayList;
import java.util.List;

class Shop {
    static List<Thread> threads = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Shop opened");
        int isP = 0;
        int nBuyer = 0;
        Manager manager = new Manager();
        Thread threadManager = new Thread(manager);
        threads.add(threadManager);
        threadManager.start();

        for (int i = 1; i <= Manager.PLAN_CASHIER; i++) {
            Cashier cashier = new Cashier(i);
            Thread thread = new Thread(cashier);
            threads.add(thread);
            thread.start();
        }

        while (Manager.shopOpened()){
            for (int i = 1; i <= 60; i++) {
                int count = getCountBuyers(i);
                for (int j = 1; j <= count && Manager.shopOpened(); j++) {
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

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Shop closed");
    }

    private static int getCountBuyers(int time) {
        int res;
        int countActive;
        countActive = Manager.IN_COUNT - Manager.OUT_COUNT;

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
