package by.it.makovsky.jd01_05;

import static java.lang.Math.E;
import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        stage1();

    }

    private static void stage1(){
        for (double a = 0;a <=2.001 ; a=a+0.2) {
            double y=pow(7,a)*6;
            for (int x = 1; x <=6 ; x++) {
                y-=cos(x);
                System.out.println(a + " " + y);
            }
        }

    }

    private static void stage2() {
        double b=0;
        double a=log(abs(b+2.74));

    }
}
