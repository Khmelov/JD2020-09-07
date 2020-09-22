package by.it.adryneuski.jd01_05;

import static java.lang.Math.abs;
import static java.lang.Math.cos;
import static java.lang.Math.log10;
import static java.lang.Math.pow;
import static java.lang.Math.sin;
import static java.lang.StrictMath.*;

public class TaskB {
    public static void main(String[] args) {

        step1();
        System.out.println();
        step2();
    }

    private static void step1() {
        double y = 0;

        for (double a = 0; a <= 2; a += 0.2) {
            for (int x = 1; x <= 6; x++) {

                y = y + pow(7, a) - cos(x);

            }
            System.out.printf("при a =%4.2f Сумма y = %e", a, y);
            System.out.println();
        }

    }

    private static void step2() {

        for (double x = -5.5; x < 2; x += 0.5) {

            if (-2 < x / 2 && x / 2 <= -1) {
                double b = sin(x * x);
                double a = log10(abs(b + 2.74));
                System.out.printf("при x/2 =%4.2f  a =%e\n", x / 2, a);
            }
            if (-1 < x / 2 && x / 2 < 0.2) {
                double b = cos(x * x);
                double a = log10(abs(b + 2.74));
                System.out.printf("При x/2=%4.2f; a=%e\n", x / 2, a);
            }

            if (x / 2 == 0.2) {
                double b = 1 / tan(x * x);
                double a = log10(abs(b + 2.74));
                System.out.printf("При x/2=%4.2f; a=%e\n", x / 2, a);
            }


            if ((x / 2 <= -2) || (x / 2 > 0.2)) {
                System.out.printf("При x/2=%4.2f; вычисления не определены\n", x / 2);
            }

        }
    }

}



