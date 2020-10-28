package by.it.yatsevich.jd02_02;

class Supervisor {
    static final Object MONITOR=new Object();

    static final int MORE_FAST = 1000;
    static int BUYER_IN_THE_SHOP=0;
    static int COUNTS_OF_GOODS;


    private static final int PLAN=100;
    private volatile static int inCount=0;
    private volatile static int outCount=0;

    static boolean shopOpened(){
        return inCount<PLAN;
    }

    static boolean planComplete(){
        return outCount==PLAN;
    }

    static void addBuyer(){
        synchronized (MONITOR){
            inCount++;
        }
    }

    static void deleteBuyer(){
        synchronized (MONITOR){
            outCount++;
        }
    }
}
