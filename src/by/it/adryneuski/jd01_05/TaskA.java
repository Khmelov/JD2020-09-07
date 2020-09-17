package src.by.it.adryneuski.jd01_05;

import static java.lang.Math.*;

public class TaskA {
    public static void main(String[] args)
    {
        double a = 756.13;
        double x = 0.3;

        System.out.println(cos1(x) - sqrt1(x,a) - log1(x,a));

        double z = cos(pow((x * x + PI / 6), 5)) - sqrt(x * pow(a, 3)) - log((a - 1.12 * x) / 4);
        System.out.println(z);

    }

    static double cos1(double x)
    {
        return cos(pow((x * x + PI / 6), 5));

    }
    static double sqrt1(double x, double a)
    {
        return sqrt(x * pow(a, 3));

    }
    static double log1(double x, double a)
    {
        return log((a - 1.12 * x) / 4);

    }
}