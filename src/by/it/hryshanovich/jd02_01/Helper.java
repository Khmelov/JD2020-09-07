package by.it.hryshanovich.jd02_01;

import java.util.Random;

class Helper {
    private static Random rnd = new Random();

    static int getRandom(int start, int stop) {
        return start + rnd.nextInt(stop - start + 1);
    }

    static int getRandom(int max) {
        return getRandom(0, max);
    }

    static void mySleep(int millis) {
        try {
            Thread.sleep(millis/Dispatcher.K_SPEED);
        } catch (InterruptedException e) {
            throw new RuntimeException("something stupid", e);
        }
    }
}
