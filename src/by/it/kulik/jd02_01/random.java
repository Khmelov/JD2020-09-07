package by.it.kulik.jd02_01;


import java.util.Random;

public class random {
    static final long init=System.currentTimeMillis();
    static final Random random = new Random(init);
    static int fromTo(int from, int to){
        //вычислим время ожидания
        int delta=to-from+1;
        return from+random.nextInt(delta);
    }

}