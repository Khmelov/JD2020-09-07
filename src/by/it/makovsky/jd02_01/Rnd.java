package by.it.makovsky.jd02_01;

import java.util.Random;

public class Rnd {
    static final long init=System.currentTimeMillis();
    static final Random random=new Random(init);

    static int fromTo(int from, int to){
        int delta=to-from+1;
        return random.nextInt(delta);
    }
    static int getRandom(int max) {
        return fromTo(0, max);
    }
    static void mySleep(int millis) {
        try {
            Thread.sleep(millis/Dispatcher.K_SPEED);
        } catch (InterruptedException e) {
            throw new RuntimeException("что-то пошло не так", e);
        }
    }
}
