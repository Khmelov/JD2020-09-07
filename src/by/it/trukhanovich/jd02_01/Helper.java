package by.it.trukhanovich.jd02_01;

import java.util.Random;

public class Helper {
    private static final Random rnd;

    static {
        rnd = new Random();
    }
//    static boolean pensioneer=false;

    static int getRandom (int start, int stop){
/*        if (pensioneer)  {
            return (int) ((start+ rnd.nextInt(stop-start+1))*1.5);
        }
        else*/ return start+ rnd.nextInt(stop-start+1);
    }

    static int getRandom (int max){
        return getRandom(0,max);
    }

    static void mySleep(int millis) {
        try {
            Thread.sleep(millis/Dispatcher.K_SPEED);
        } catch (InterruptedException e) {
            throw new RuntimeException("something stupid", e);
        }
    }
}
