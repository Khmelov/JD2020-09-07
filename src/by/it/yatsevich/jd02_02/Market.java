package by.it.yatsevich.jd02_02;



import java.util.ArrayList;

class Market {
    public static void main(String[] args) {
        System.out.println("##Market open##");
        int number=0;
        ArrayList<Thread> threads=new ArrayList<>();
        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier(i);
            Thread thread = new Thread(cashier);
            threads.add(thread);
            thread.start();
        }
        
        while (Supervisor.shopOpened()){
            int countBuyer= Helper.getRandom(2);
            for (int i = 0;Supervisor.shopOpened()&& i < countBuyer; i++) {
                Buyer buyer=new Buyer(++number);
                buyer.start();
                threads.add(buyer);
                Supervisor.BUYER_IN_THE_SHOP++;

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
    while (Supervisor.BUYER_IN_THE_SHOP>0)Thread.yield();
        System.out.println("##Market closed##");
    }
}
