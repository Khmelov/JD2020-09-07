package by.it.yatsevich.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

class Supervisor {

    static final int MORE_FAST = 1000;
    static AtomicInteger BUYER_IN_THE_SHOP=new AtomicInteger(0);
    static AtomicInteger COUNTS_OF_GOODS=new AtomicInteger(0);


    private static final int PLAN=100;
    private static final AtomicInteger inCount=new AtomicInteger(0);
    private static final AtomicInteger outCount=new AtomicInteger(0);

    static boolean shopOpened(){
        return inCount.get()<PLAN;
    }

    static boolean planComplete(){
        return outCount.get()==PLAN;
    }

    static void addBuyer(){
            inCount.getAndIncrement();
    }

    static void deleteBuyer(){
            outCount.getAndIncrement();
    }
}
