package by.it.drugov.jd01_05;

import java.util.Arrays;

import static java.lang.Math.*;

public class TaskC {
    public static void main(String[] args) {
         step1();
        step2();
    }

    private static void step2() {
        int[] array = new int[31];
        printArrayA(array);
        printArrayB(array);
    }
    // не сделал вывод массива B
    private static void printArrayB(int[] array) {
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if ((array[i] * 0.1) > (i + 1)) {
                index++;
            }
        }
        int[] arrayB = new int[index];
        Arrays.sort(arrayB);
        int cols = (int) Math.ceil((double) arrayB.length / 7);

        System.out.print("╔");
        for (int i = 0; i < cols; i++) {
            if (i + 1 == cols) {
                System.out.print("════════════╗\n║");
                break;
            }
            System.out.print("════════════╦");
        }

        for (int i = 0; i < 7; i++) {
            System.out.printf(" B[%2d]=%-4d ║", i, arrayB[i]);
            for (int j = 0; j < cols; j++) {
                System.out.println("Не сделал");

            }

        }
    }

    private static void printArrayA(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (random() * 348 + 103);
        }
        System.out.print("╔════════════╦════════════╦════════════╦════════════╦════════════╗\n║");
        for (int i = 0; i < array.length; i++) {
            System.out.printf(" A[%2d]=%-4d ║", i, array[i]);
            if ((i + 1) % 5 == 0 && (i + 1 != array.length)) {
                System.out.println("\n╠════════════╬════════════╬════════════╬════════════╬════════════╣");
                System.out.print("║");
            }
            if (i + 1 == array.length) {
                System.out.println("            ║            ║            ║            ║");
                System.out.println("╚════════════╩════════════╩════════════╩════════════╩════════════╝");
            }
        }
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
            if (arrayB[i] != 0)
                average *= arrayB[i];
            System.out.printf("arrB[ %-2d] = %-11.5f", i, arrayB[i]);
            if ((i + 1) % 5 == 0 || i == arrayB.length - 1) {
                System.out.println();
            }
        }
        average = pow(average, (double) 1 / arrayB.length);
        System.out.println("Среднее геометрическое массива arrayB = " + average);

    }
}
