package by.it.makovsky.jd02_03;

import java.util.Random;

class Rnd {
    private Rnd() {
    }

    private static final Random random = new Random();

    private static final int K_SPEED = 100;

    static int fromTo(int from, int to){
        return from + random.nextInt(to - from + 1);
    }
    static int getRandom(int max) {
        return fromTo(0, max);
    }
    static void mySleep(int millis) {
        try {
            Thread.sleep(millis/ K_SPEED);
        } catch (InterruptedException e) {
            throw new RuntimeException("что-то пошло не так", e);
        }
    }
}
