package by.it.shkatula.jd02_02;

class Dispatcher {

    private static final int PLAN = 100;
    private volatile static int countEnterToMarket = 0;
    private volatile static int countOutFromMarket = 0;

    static synchronized void buyerEnterToMarket() {
        //Object monitor = Dispatcher.class;
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



    static final int K_SPEED = 100;
}
