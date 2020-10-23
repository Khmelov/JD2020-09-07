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
        ArrayList<Integer> buyers = new ArrayList<>();
        int number = 0;
        for (int time = 1; time <= 120; time++) {
            int countBuyer = getCountBuyers(time);
            for (int i = 0; i < countBuyer; i++) {
                Buyer buyer = new Buyer(++number);
                buyer.start();
                Supervisor.BUYER_IN_THE_SHOP++;
            }
            Helper.buyerSleep(1000);
            buyers.add(Supervisor.BUYER_IN_THE_SHOP);

        }
        while (Supervisor.BUYER_IN_THE_SHOP > 0) Thread.yield();
        System.out.println("##Market closed##");
        for (int i = 0; i < buyers.size(); i++) {
            System.out.printf("%3d sec - %4d buyers\n", i, buyers.get(i));
        }
    }

    private static int getCountBuyers(int time) {

        int value = 0;
        int modifier = 0;
        if (time > 60)
            modifier = 60;
        if (time == 1) value = 10;
        if (time <= 30 || time > 60 && time <= 90) value = 10 + time-modifier - Supervisor.BUYER_IN_THE_SHOP;
        if (time > 30 && time <= 60 || time > 90) {
            if (Supervisor.BUYER_IN_THE_SHOP <= 40 + (30 - time + modifier)) {
                value = 40 + (30 - time + modifier) - Supervisor.BUYER_IN_THE_SHOP;
            }
        }


        return value;
    }
}
