package by.it.drugov.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step2() {
        double b = 0;
        for (double x = -5.5; x < 2; x += 0.5) {
            boolean flag = true;
            if ((x / 2 > -2) && (x / 2 <= -1)) {
                b = sin(x * x);
            } else {
                if((x/2 >-1)&&(x/2 < 0.2) ) {
                    b = cos(x*x);
                } else {
                    if(x/2 == 0) {
                        b = 1/tan(x*x);
                    } else {
                        System.out.printf("При x/2=%4.2f вычисления не определены\n", x / 2);
                        flag = false;
                    }
                }
            }
            double a = log10(abs(b + 2.74));
            if (flag) {
                System.out.printf("При x/2=%4.2f a = %-7.5e \n", x / 2, a);
            }
        }
    }

    private static void step1() {
        double sum = 0;
        for (double a = 0; a <= 2; a += 0.2) {
            for (int x = 1; x < 7; x++) {
                double y = pow(7, a) - cos(x);
                sum += y;
                System.out.printf("При a=%4.2f Сумма y = %7.4f \n", a, sum);
            }
        }
    }
}
