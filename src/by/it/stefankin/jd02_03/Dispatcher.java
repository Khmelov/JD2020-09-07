package by.it.stefankin.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

class Dispatcher {

    private static final int PLAN = 100;
    private static final AtomicInteger countEnterToMarket = new AtomicInteger(0);
    private static final AtomicInteger countOutFromMarket = new AtomicInteger(0);

    static final int K_SPEED = 100;

    static void buyerEnterToMarket() {

        countEnterToMarket.getAndIncrement();
    }

    static void buyerLeaveMarket() {

        countOutFromMarket.getAndIncrement();
    }

    static boolean marketIsOpenedForNewBuyer(){

        return countEnterToMarket.get()!=PLAN;
    }

    static boolean marketIsClosed(){

        return countOutFromMarket.get()==PLAN;
    }



}
