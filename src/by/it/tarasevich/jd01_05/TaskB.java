package by.it.tarasevich.jd01_05;

import static java.lang.Math.*;

public class TaskB {

    public static void main(String[] args) {

        TaskB1();
        TaskB2();


    }

    private static void TaskB1() {

        System.out.println("Task B1");
        for (double a = 0; a <= 2; a = a + 0.2) {
            double y = 0;
            for (double x = 1; x <= 6; x++) {
                y = y + (pow(7, a) - cos(x));
                System.out.printf("if a=%f : y =%e\n  ", a, y);
            }
        }


    }


    private static void TaskB2() {
        System.out.println("Task B2");
        for (double x = -5.5; x < 2; x = x + 0.5) {
            if (x / 2 > -2 && x / 2 <= -1) {
                double b = sin(x * x);
                double a = log10(abs(b + 2.74));
                System.out.printf("x/2 = %f; a = %e\n", x / 2, a);
            }
            if (x / 2 > -1 && x / 2 <= 0.2) {
                double b = cos(x * x);
                double a = log10(abs(b + 2.74));
                System.out.printf("x/2 = %f; a = %e\n", x / 2, a);
            }
            if (x / 2 == 0.2) {
                double b = cos(x * x);
                double a = log10(abs(b + 2.74));
                System.out.printf("x/2 = %f; a = %e\n", x / 2, a);
            }
            if (x / 2 <= -2 || x / 2 > 0.2) {
                System.out.printf("x/2 = %f; not answers\n", x / 2);

            }
        }
    }
}




