package by.it.trukhanovich.jd01_06;

import java.util.Random;

public class RandomTest {
    public static void main(String[] args) {
        int lenght=15;
        Random random=new Random(18);
        for (int i = 0; i < 10; i++) {
            int j= (int)random.nextInt(15);
            System.out.println(j);
        }
    }
}
