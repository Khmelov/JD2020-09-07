package by.it.drugov.jd01_05;

import static java.lang.Math.*;

public class TaskC {
    public static void main(String[] args) {
        step1();
    }

    private static void step1() {
        double[] array = new double[(int) (random() * 21 + 20)];
        double z;
        int index = 0;
        int cnter = 0;
        for (double x = 5.33; x <= 9; x += (9 - 5.33) / array.length) {
            z = cbrt(x * x + 4.5);
            if (z > 3.5) {
                cnter++;
            }
            if (index < array.length) {
                array[index] = z;
            }
            index++;
        }
        index = 0;
        double[] arrayB = new double[cnter];
        for (double element : array) {
            if (element > 3.5) {
                arrayB[index] = element;
                index++;
            }
        }

        for (int i = 0; i < array.length; i++) {
            System.out.printf("arr[ %-2d] = %-11.5f", i, array[i]);
            if ((i + 1) % 5 == 0 || i == array.length - 1) {
                System.out.println();
            }
        }
        double average = 1;
        for (int i = 0; i < arrayB.length; i++) {
            if(arrayB[i]!=0)
            average *= arrayB[i];
            System.out.printf("arrB[ %-2d] = %-11.5f", i, arrayB[i]);
            if ((i + 1) % 5 == 0 || i == arrayB.length - 1) {
                System.out.println();
            }
        }
        average = pow(average,(double) 1 / arrayB.length);
        System.out.println("Среднее геометрическое массива arrayB = " + average);

    }
}
