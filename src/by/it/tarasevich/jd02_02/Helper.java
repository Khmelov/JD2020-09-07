package by.it.tarasevich.jd02_02;

import java.util.Random;

public class Helper {

    private static Random random = new Random();
    static int getRandom(int start ,int stop) {
         return start+random.nextInt(stop-start + 1);
    }
    static int getRandom(int max){
        return getRandom(0,max);
    }
    static void mySleep(int millis){
        try {
            Thread.sleep(millis/ Dispatcher.K_SPEED);
        }catch (InterruptedException e){
            throw new RuntimeException("something not good",e);
        }
    }
}
