package by.it.hryshanovich.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }
    public static void step1 () {
        for (double i = 0; i <=2 ; i=i + 0.2) {
            double j = 0;
            for (int x = 1; x <= 6; x++) {
                if (i >= 0 && i <= 2) {
                    j = j + (pow(7, i)) - cos(x);
                }
                else {
                    System.out.println("а не принадлежит этому диапазону");
                }
            }
            System.out.printf("При a=%-2.2f; y=%e\n", i, j);
        }

    }
    public static void step2 () {
        for (double x = -5.5; x < 2 ; x = x+ 0.5) {

            double a=0;
            if (x/2>-2 && x/2<=-1) {
                a=log10(abs((sin(pow(x,2))+2.74)));
                System.out.printf("При x/2=%-2.2f a=%e\n", x, a);
            }
            if (x/2>-1 && x/2<0.2) {
                a=log10(abs(cos(pow(x,2))+2.74));
                System.out.printf("При x/2=%-2.2f a=%e\n", x, a);
            }
            if (x/2== 0.2) {
                a=log10(abs(1.0/(tan(pow(x,2))+2.74)));
                System.out.printf("При x/2=%-2.2f a=%e\n", x, a);
            }
            if (a == 0) {
                System.out.printf("При x/2=%-2.2f вычисления не определены\n", x);
            }
        }
    }
}
