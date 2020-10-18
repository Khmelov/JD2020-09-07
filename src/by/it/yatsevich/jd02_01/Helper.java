package by.it.yatsevich.jd02_01;

import java.util.Random;

class Helper {
    private static final Random random = new Random();
    static int start = 500;
    static int stop = 2000;
    static double pensionValue =1.5;
    static boolean pensioner =false;
    static int getRandom(int start,int stop){
        return start + random.nextInt(stop-start+1);
    }

    static int getRandom(int max){
        return getRandom(0,max);
    }

    static void buyerSleep(int millis){
        try {
            Thread.sleep(millis/Supervisor.MORE_FAST);
        } catch (InterruptedException e) {
            throw new RuntimeException("##SOME WARNING##",e);
        }
    }
}
