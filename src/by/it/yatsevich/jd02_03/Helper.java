package by.it.yatsevich.jd02_03;

import java.util.Random;

class Helper {
    private static final Random random = new Random();

    static int getRandom(int start,int stop){
        return start + random.nextInt(stop-start+1);
    }

    static int getRandom(int max){
        return getRandom(0,max);
    }
    static int getRandomGoods(){return 1 + random.nextInt(4);}

    static void sleep(int millis){
        try {
            Thread.sleep(millis/ Supervisor.MORE_FAST);
        } catch (InterruptedException e) {
            throw new RuntimeException("##SOME WARNING##",e);
        }
    }
}
