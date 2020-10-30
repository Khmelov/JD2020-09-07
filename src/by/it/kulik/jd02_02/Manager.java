package by.it.kulik.jd02_02;

public class Manager {
    static final int K_SPEED=10;
    static final Object MONITOR=new Object();

    private static final int PLAN=100;
    private volatile static  int inCount=0;
    private volatile static int outCount=0;

    static boolean shopOpened(){
        return inCount<PLAN;
    }
    static boolean planCompleted(){
        return outCount==PLAN;
    }
    static  void addBuyer(){
        synchronized (MONITOR){
            inCount++;
        }
    }
    static void offBuyer(){
        synchronized (MONITOR){
            outCount++;
        }
    }
}
