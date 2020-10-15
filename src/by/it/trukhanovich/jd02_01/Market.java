package by.it.trukhanovich.jd02_01;

import java.util.ArrayList;

public class Market {
    public static void main(String[] args) {
        MarketHelper marketHelper = new MarketHelper();
        marketHelper.getGoodToPrice();
        System.out.println("Market opened");
        ArrayList<Buyer> buyerArrayList = new ArrayList<>();
        int number=0;
        int second=0;
        ArrayList<Integer> buyerOfEverySecond = new ArrayList<>();
        for (int timeSecond = 1; timeSecond <=120; timeSecond++) {
            int countBuyer=Helper.getRandom(2);
            for (int j = 0; j < countBuyer; j++) {
                Buyer buyer=new Buyer(++number);
                buyer.start();
                buyerArrayList.add(buyer);
                Dispatcher.BUYERS_IN_SHOP++;
            }
            Helper.mySleep(1000);
            second++;
            buyerOfEverySecond.add(Dispatcher.BUYERS_IN_SHOP);
        }
        while (Dispatcher.BUYERS_IN_SHOP>0){
            Thread.yield();
        }
        for (int i = 0; i < buyerOfEverySecond.size(); i++) {
            System.out.printf("В секунду %d в магазине было %d\n", i, buyerOfEverySecond.get(i));
        }
        System.out.println("Market closed");
    }
}
