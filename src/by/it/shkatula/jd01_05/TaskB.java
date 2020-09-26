package by.it.shkatula.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        taskB1();
        taskB2();
    }

    private static void taskB1() {

        for (double a = 0; a <= 2; a += 0.2) {
            double y = pow(7, a);
            for (int x = 1; x <= 6; x++) {
                y = y - cos(x);
                System.out.printf("При a=%4.2f y=%g\n", a, y);
            }
        }
    }

    private static void taskB2() {

        for (double x = -6; x < 2; x += 0.5) { double b;
            if (-2 < x / 2 && x / 2 <= -1) {
                b = sin(pow(x, 2));
                double a = log10(abs(b + 2.74));
                System.out.printf("При x/2=%4.2f a=%g\n", x/2, a);
            } else if (-1 < x / 2 && x / 2 < 0.2) {
                b = cos(pow(x, 2));
                double a = log10(abs(b + 2.74));
                System.out.printf("При x/2=%4.2f a=%g\n", x/2, a);
            } else if (x / 2 == 0.2) {
                b = 1 / tan(pow(x, 2));
                double a = log10(abs(b + 2.74));
                System.out.printf("При x/2=%4.2f a=%g\n", x/2, a);
            } else if (x <=-2 || x > 0.2){
                  System.out.println("вычисления не определены");
            }


        }



    }

}
