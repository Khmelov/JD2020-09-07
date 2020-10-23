package by.it._akhmelev_.jd02_03;

import java.util.Random;

class Helper {

    private Helper() {
    }

    private static final Random rnd = new Random();

    private static final int K_SPEED = 100;


    static int getRandom(int start, int stop) {
        return start + rnd.nextInt(stop - start + 1);
    }

    @SuppressWarnings("SameParameterValue")
    static int getRandom(int max) {
        return getRandom(0, max);
    }

    static void mySleep(int millis) {
        try {
            Thread.sleep(millis / K_SPEED);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
