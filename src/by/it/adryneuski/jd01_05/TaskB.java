package by.it.adryneuski.jd01_05;

import static java.lang.StrictMath.*;

public class TaskB {
    public static void main(String[] args) {

        step1();
        System.out.println();
        step2();
    }

    private static void step1()
        {
        double y = 0;

        for (double a = 0; a <= 2 ; a+=0.2) {
            for (int x = 1; x <= 6 ; x++) {

               y = y + pow(7,a) - cos(x);

            }
            System.out.printf("при a =%6.2f Сумма y = %e",a,y);
            System.out.println();
        }

    }

    private static void step2() {

        for (double x = -5.5; x < 2; x += 0.5){

            if ((-2 < (x/2))&((x/2) <= -1))
            {
                double a = log(abs(sin(x) * sin(x) + 2.74));
                System.out.printf("при x/2 =%6.2f  a =%-20.10e\n", x/2, a);
            }
              else if ((-1 < (x/2))&((x/2) < 0.2))
              {
                double a = log(abs(cos(x) * cos(x) + 2.74));

                System.out.printf("при x/2 =%6.2f  a =%-20.10e\n", x/2, a);
              }

//              else if (x == 0.4)
//              {
//                double a = log(abs(1 / tan(x) + 2.74));
//
//                System.out.printf("при x =%4.2f  a =%-6.2f\n", x, a);
//              }
            else
        System.out.printf("при x/2 =%4.2f  вычисления не определены\n", x/2);

    }

    }

}
