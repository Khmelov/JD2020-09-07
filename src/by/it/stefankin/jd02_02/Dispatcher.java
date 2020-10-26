package by.it.stefankin.jd02_02;

class Dispatcher {

    private static final int PLAN = 100;
    private volatile static int countEnterToMarket = 0;
    private volatile static int countOutFromMarket = 0;

    static final int K_SPEED = 100;

    static synchronized void buyerEnterToMarket() {
        countEnterToMarket++;
    }

    static synchronized void buyerLeaveMarket() {

        countOutFromMarket++;
    }

    static boolean marketIsOpenedForNewBuyer(){

        return countEnterToMarket!=PLAN;
    }

    static boolean marketIsClosed(){

        return countOutFromMarket==PLAN;
    }



}
