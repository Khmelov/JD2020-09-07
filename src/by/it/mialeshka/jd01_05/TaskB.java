package by.it.mialeshka.jd01_05;

import static java.lang.Math.*;
public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step2() {
       for (double x = -5.5; x< 2; x=x+0.5){
           double b = 0.0;
           if(x/2.0 > 0.2 || x/2.0<= -2){
               System.out.printf("При x/2=%4.2f вычисления не определены\n", x/2.0);
           }
           else {
               if (x / 2.0 > -2 && x / 2.0 <= -1)
                   b = sin(x*x);
               if (x / 2.0 > -1 && x / 2.0 < 0.2)
                   b = cos(x*x);
               if (x / 2.0 == 0.2)
                   b = 1.0/tan(x*x);

               double a = log10(abs(b+2.74));
               System.out.printf("При x/2=%4.2f a=%g\n", x/2.0, a);
           }

       }
    }

    private static void step1() {
        for (double a = 0.0; a <= 2.0; a=a+0.2){
            double ay =pow(7, a);
            double y = 0.0;
            for (int x = 1; x < 7; x++) {
                y = y + (ay - cos(x));
            }
            System.out.printf("При a=%4.2f Cумма y=%g\n", a, y);
        }
    }
}
