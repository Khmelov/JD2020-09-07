package by.it.mialeshka.jd02_03;

import java.util.Random;

class Helper {
    private static final Random generateTime = new Random();

    private Helper() {
    }

    public static int getRandom(int start, int end) {
        if(start > 0) return start + generateTime.nextInt(end-start+1);
        else return generateTime.nextInt(end);
    }

    public static void sleep(int timeout) {
        try {
            Thread.sleep(timeout/ Dispatcher.K_SPEED);
        } catch (InterruptedException e) {
            throw new RuntimeException("Interrupted" + Thread.currentThread(), e);
        }
    }
}
