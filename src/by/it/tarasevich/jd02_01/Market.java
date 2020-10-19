package by.it.tarasevich.jd02_01;

import java.util.ArrayList;

public class Market {


    public static void main(String[] args) {
        System.out.println("Market opened");
        ArrayList<Buyer> buyers = new ArrayList<>();
        int number = 0;
        for (int timeSecond = 1; timeSecond <= 120; timeSecond++) {
            int countBuyer = Helper.getRandom(5);
            for (int i = 0; i < countBuyer; i++) {
                Buyer buyer = new Buyer(++number);
                buyer.start();
                buyers.add(buyer);
                Dispatcher.BUYERS_IN_SHOP++;
            }
            Helper.mySleep(1000);
        }
        for (Buyer buyer : buyers) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }System.out.println("Market closed.");
    }
}
