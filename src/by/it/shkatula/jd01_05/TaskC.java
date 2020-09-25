package by.it.shkatula.jd01_05;
import java.util.Arrays;

import static java.lang.Math.*;
public class TaskC {
    public static void main(String[] args) {
        taskC1();
    }

    private static void taskC1() {

    int n = (int) (20 + Math.random()*21);
double[] arrayA = new double[n];
        for (int i = 0; i < arrayA.length; i++) {
            for (double x = 5.33; x <= 9; x++) {
                double z = cbrt(x*x+4.5);
                arrayA[i] = z;
                System.out.println(Arrays.toString(arrayA));
            }

        }
    }
}
