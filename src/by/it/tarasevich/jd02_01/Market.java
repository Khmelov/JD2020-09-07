package by.it.tarasevich.jd02_01;

import java.util.ArrayList;

public class Market {


    public static void main(String[] args) {
        Helper helper = new Helper();
        helper.getGoodToPrice();
        System.out.println("Market opened");
        ArrayList<Integer> buyers = new ArrayList<>();
        int number = 0;
        for (int timeSecond = 1; timeSecond <= 120; timeSecond++) {
            int countBuyer = getCountBuyer(timeSecond);
            for (int i = 0; i < countBuyer; i++) {
                Buyer buyer = new Buyer(++number);
                buyer.start();

                Dispatcher.BUYERS_IN_SHOP++;
            }
            Helper.mySleep(1000);
            buyers.add(Dispatcher.BUYERS_IN_SHOP);
        }
        while (Dispatcher.BUYERS_IN_SHOP > 0) {
            Thread.yield();
        }
        System.out.println("Market closed.");
        for (int i = 0; i < buyers.size(); i++) {
            System.out.printf("Во время %d не было %d\n ", i, buyers.get(i));
        }
    }

    private static int getCountBuyer(int timeSecond) {
        int countBuyer = 0;
        int correct = 0;
        if (timeSecond == 1) {
            countBuyer = 10;
        }
        if (timeSecond > 60) {
            correct = 60;
        }
        if ((timeSecond <= 30 && timeSecond > 1) || (timeSecond <= 90 && timeSecond > 60)) {
            countBuyer = (timeSecond - correct + 11) - Dispatcher.BUYERS_IN_SHOP;
        }
        if (timeSecond <= 60 && timeSecond > 30 || timeSecond > 90) {
            if (Dispatcher.BUYERS_IN_SHOP <= 40 + (30 - timeSecond + correct)) {
                countBuyer = (41 + (30 - timeSecond + correct)) - Dispatcher.BUYERS_IN_SHOP;
            }
        }
        return countBuyer;
    }
}
