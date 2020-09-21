package by.it.hryntsaliou.jd01_05;

import static java.lang.StrictMath.*;

class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step2() {
        double b;
        for (double x = -5.5; x <= 1.5; x += 0.5) {
            if (x / 2 <= -2 || x / 2 > 0.2) {
                System.out.printf("При x/2=%4.2f вычисления не определены", x / 2);
                System.out.println();
            }
            if (x / 2 > -2 && x / 2 <= -1) {
                b = sin(x * x);
                method(b, x);
            }
            if (x / 2 > -1 && x / 2 < -0.2) {
                b = cos(x * x);
                method(b, x);
            }
            if (x / 2 == 0.2) {
                b = 1 / tan(x * x);
                method(b, x);
            }
        }
    }

    private static void method(double b, double x) {
        double a = log10(b + 2.74);
        System.out.printf("При x/2=%4.2f a = %e", x / 2, a);
        System.out.println();
    }

    private static void step1() {
        double y = 0;
        for (double a = 0; a <= 2; a += 0.2) {
            for (int x = 1; x <= 6; x++) {
                y += pow(7, a) - cos(x);
            }
            System.out.printf("При a=%3.2f Сумма y = %e", a, y);
            System.out.println();
        }
    }
}
