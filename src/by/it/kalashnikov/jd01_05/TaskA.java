package by.it.kalashnikov.jd01_05;
import static java.lang.Math.*;
class TaskA {

    public static void main(String[] args) {
        step1();
        step2();
        step3();
    }

    private static void step1() {
        double a = 756.13;
        double x = 0.3;
        double firstPart = cos(pow(((pow(x,2)) + PI/6),5));
        double secondPart = sqrt(x*pow(a,3));
        double thirdPart = log(abs((a-1.12*x)/4));
        double z = firstPart - secondPart - thirdPart;
        System.out.println("z="+z);
    }
    private static void step2() {
        double a = 1.21;
        double b = 0.371;
        double firstPart = tan(pow(a+b,2));
        double secondPart = cbrt(a + 1.5) + a * pow(b, 5);
        double thirdPart =  b/log(pow(a,2));
        double y = tan(pow(a+b,2)) - cbrt(a + 1.5) + a * pow(b, 5) - b/log(pow(a,2));
        System.out.println("y="+y);
    }
    private static void step3() {
        double x = 12.1;
        for (double a = -5; a <= 12 ; a=a+3.75) {
            double f = exp(a*x) - 3.45*a;
            System.out.printf("При a=%5.5f f=%g\n",a,f);
        }

    }


}
