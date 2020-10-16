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
        ArrayList<Buyer> buyers=new ArrayList<>();
        int number=0;
        for (int timesecond = 1; timesecond <=120 ; timesecond++) {
            int countBuyer=Helper.getRandom(2);
            for (int i = 0; i < countBuyer; i++) {
                Buyer buyer=new Buyer(++number);

                buyer.start();
                buyers.add(buyer);
                Supervisor.BUYER_IN_THE_SHOP++;
            }
            Helper.buyerSleep(1000);
        }
    while (Supervisor.BUYER_IN_THE_SHOP>0)Thread.yield();
        System.out.println("##Market closed##");
    }
}
