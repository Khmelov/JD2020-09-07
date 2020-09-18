package by.it.trukhanovich.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();

    }

    private static void step2() {
        System.out.println("Step2");
        for (double x = -5.5; x < 2; x = x + 0.5) {
                if (x / 2 > -2 && x / 2 <= -1) {
                double b = sin(x * x);
                double a = log10(abs(b + 2.74));
                System.out.printf("При x/2=%f; a=%e\n", x / 2, a);
            }
            if (x / 2 > -1 && x / 2 <= 0.2) {
                double b = cos(x * x);
                double a = log10(abs(b + 2.74));
                System.out.printf("При x/2=%f; a=%e\n", x / 2, a);
            }
            if (x / 2 == 0.2) {
                double b = cos(x * x);
                double a = log10(abs(b + 2.74));
                System.out.printf("При x/2=%f; a=%e\n", x / 2, a);
            }
            if ((x / 2 <= -2) || (x / 2 > 0.2)) {
                System.out.printf("При x/2=%f; вычисления не определены\n", x / 2);
            }
        }

    }



        private static void step1 () {
            System.out.println("Step1");
            for (double a = 0; a <= 2; a = a + 0.2) {
                double y = 0;
                for (int x = 1; x <= 6; x++) {
                    y = y + ((pow(7, a)) - cos(x));
                }
                System.out.printf("При а=%f; y=%e\n", a, y);

            }
        }
}

