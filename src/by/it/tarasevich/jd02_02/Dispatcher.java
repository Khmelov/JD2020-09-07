package by.it.tarasevich.jd02_02;

public class Dispatcher {
    private static final int PLAN = 100;
    static final int K_SPEED = 100;
    private volatile static int countEnterMarket = 0;
    private volatile static int countOutFromMarket = 0;

    public static void buyerEnterToMarket() {
        countEnterMarket++;
    }
    static synchronized void BuyerLeaveMarket(){countOutFromMarket++;}

    static  boolean marketIsOpenForNewBuyer(){return countEnterMarket!= PLAN;}

    static boolean marketIsCloused(){return countOutFromMarket==PLAN;}
}
