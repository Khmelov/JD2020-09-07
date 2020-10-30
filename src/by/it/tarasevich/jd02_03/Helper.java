package by.it.tarasevich.jd02_03;

import java.util.Random;

class Helper {

    private Helper(){}

    private static Random random = new Random();
    private static final int K_SPEED = 100;
    static int getRandom(int start ,int stop) {
         return start+random.nextInt(stop-start + 1);
    }
    static int getRandom(int max){
        return getRandom(0,max);
    }
    static void mySleep(int millis){
        try {
            Thread.sleep(millis/ K_SPEED);
        }catch (InterruptedException e){
            throw new RuntimeException("something not good",e);
        }
    }
}
