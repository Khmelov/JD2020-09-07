package by.it.shkatula.jd02_01;

import java.util.ArrayList;

public class Market {
    public static void main(String[] args) {
        Dispatcher.BUYERS_IN_SHOP=0;
        main1(args);

    }

    public static void main1(String[] args) {
        System.out.println("Market opened");
        ArrayList<Buyer> buyers = new ArrayList<>();
        int number = 0;
        for (int timeSecond = 0;  timeSecond <120; timeSecond++) {
            int countBuyer = Helper.getRandom(2);
            for (int i = 0; i <= countBuyer ; i++) {
                Buyer buyer = new Buyer(++number);
                buyer.start();
                buyers.add(buyer);
                Dispatcher.BUYERS_IN_SHOP++;
            }
            System.out.println(Dispatcher.BUYERS_IN_SHOP);
            Helper.mySleep(1000);
        }

        while (Dispatcher.BUYERS_IN_SHOP>0){
            Thread.yield();
        }
        System.out.println("Market closed");
    }
}
