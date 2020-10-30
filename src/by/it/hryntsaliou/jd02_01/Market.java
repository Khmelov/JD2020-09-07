package by.it.hryntsaliou.jd02_01;

public class Market {

    public static void main(String[] args) {
        Dispatcher.BUYERS_IN_SHOP=0;
        for (int i = 0; i < 1000; i++) {
            main1(args);
        }
    }

    public static void main1(String[] args) {
        System.out.println("Market opened");
        int number = 0;
        for (int timeSecond = 1; timeSecond <= 120; timeSecond++) {
            int countBuyer = Helper.getRandom(2);
            for (int i = 0; i < countBuyer; i++) {
                Buyer buyer = new Buyer(++number);
                buyer.start();
                Dispatcher.BUYERS_IN_SHOP++;
            }
            Helper.mySleep(1000);
        }
        while (Dispatcher.BUYERS_IN_SHOP>0){
            Thread.yield();
        }
        System.out.println("Market closed");
    }
}
