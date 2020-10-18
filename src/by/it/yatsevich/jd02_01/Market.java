package by.it.yatsevich.jd02_01;


import java.util.ArrayList;

class Market {
    //    public static void main(String[] args) {
//        Supervisor.BUYER_IN_THE_SHOP=0;
//        for (int i = 0; i < 1000; i++) {
//
//            main1(args);
//        }
//    }
    public static void main(String[] args) {
        System.out.println("##Market open##");
        ArrayList<Buyer> buyers = new ArrayList<>();
        int number = 0;
        for (int timesecond = 1; timesecond <= 120; timesecond++) {
            int value;
            if (timesecond % 60 == 0) value = timesecond + 10;
            else if (timesecond % 30 == 0) value = 40 + (30 - timesecond);
            else value =  10;
//            int countBuyer = Helper.getRandom(value);
            for (int i = 0; i < value; i++) {
                if (Supervisor.COUNTS_OF_BUYERS<Supervisor.MAX_BUYERS){
                Buyer buyer = new Buyer(++number);
                buyer.start();
                buyers.add(buyer);
                Supervisor.COUNTS_OF_BUYERS++;
                Supervisor.BUYER_IN_THE_SHOP++;
                }
            }
            Helper.buyerSleep(1000);
        }
        for (Buyer buyer : buyers) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        while (Supervisor.BUYER_IN_THE_SHOP > 0) Thread.yield();
        System.out.println("##Market closed##");
    }
}
