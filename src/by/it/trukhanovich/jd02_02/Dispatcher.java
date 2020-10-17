package by.it.trukhanovich.jd02_02;

public class Dispatcher {
    static final int K_SPEED=1000;

    private volatile static int countEnterToMarket=0;

    private volatile static int countOutFromMarket=0;

    private static final int PLAN=100;

    private volatile static int countActivCashiers=0;
    static synchronized void cashiersTurnOn(){
        countActivCashiers++;
    }
    static synchronized void cashiersTurnOff(){
        countActivCashiers--;
    }

    static synchronized void buyerEnterToMarket(){
        countEnterToMarket++;
    }
    static synchronized void buyerLeaveMarket(){
        countOutFromMarket++;
    }
    static boolean marketIsOpenedForNewBuyer(){
        return countEnterToMarket!=PLAN;
    }
    static boolean marketIsClosed (){
        return countOutFromMarket==PLAN;
    }
}
