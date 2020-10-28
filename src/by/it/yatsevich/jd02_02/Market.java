package by.it.yatsevich.jd02_02;



import java.util.ArrayList;

class Market {
    public static void main(String[] args) {
        System.out.println("##Market open##");
        int number=0;
        ArrayList<Thread> threads=new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            Cashier cashier = new Cashier(i);
            Thread thread = new Thread(cashier);
            threads.add(thread);
            thread.start();
        }

        Thread threadMan=new Thread(new CashierManager());
        threadMan.setDaemon(true);
        threadMan.start();

        while (Supervisor.shopOpened()){
            int time=0;
            int countBuyer= getCountBuyers(time);
            for (time = 0;Supervisor.shopOpened()&& time < countBuyer; time++) {
                Buyer buyer=new Buyer(++number);
                synchronized (buyer){
                    buyer.start();
                    threads.add(buyer);
                    Supervisor.BUYER_IN_THE_SHOP++;
                }
            }

            Helper.sleep(1000);
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    while (!Supervisor.planComplete())Thread.yield();
        System.out.println("##Market closed##");
    }

    private static int getCountBuyers(int time) {

        int value = 0;
        int modifier = 0;
        if (time > 60)
            modifier = 60;
        if (time == 1) value = 10;
        if (time <= 30 || time > 60 && time <= 90) value = 10 + time-modifier ;
        if (time > 30 && time <= 60 || time > 90) {
            if (Supervisor.BUYER_IN_THE_SHOP <= 40 + (30 - time + modifier)) {
                value = 40 + (30 - time + modifier) - Supervisor.BUYER_IN_THE_SHOP;
            }
        }


        return value;
    }
}
