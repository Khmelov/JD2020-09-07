package by.it.ilysuchanka.jd01_05;

import static java.lang.Math.*;

public class TaskA {
    public static void main(String[] args) {
        step1();
        step2();
        step3();


    }

    private static void step1() {
        double z, x = 0.3, a = 756.13;
        z = cos(pow((x * x + PI / 6), 5)) - sqrt(x * a * a * a) - log(abs((a - 1.12*x) / 4));
        double c = cos(pow((x * x + PI / 6), 5));
        double s = sqrt(x * a * a * a);
        double l = log(abs((a - 1.12) / 4));
        double var2=c-s-l;
         System.out.println(z);
        System.out.println(var2);
            }
    private static void step2() {
        double a=1.21, b=0.371, y;
        y= tan(pow((a+b), 2))- cbrt(a+1.5)+a* pow(b, 5)- b/(log(a*a));
        System.out.println("y="+ y);
    }

    private static void step3() {
        double x=12.1;
        for(double a=-5; a<=12; a=a+3.75){
            double f=exp(a*x)-3.45*a;
            System.out.printf("При а=%6.2f f=%g\n", a, f);
        }
    }
}