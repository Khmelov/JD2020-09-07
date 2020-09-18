package by.it.hryntsaliou.jd01_05;


import static java.lang.StrictMath.*;

class TaskC {
    public static void main(String[] args) {
        step1();
        //step2();
    }

    private static void step1() {
        double[] array = new double[(int)(random()*21+20)];
        int i = 0;
        for (double x = 5.33; x <= 9; x += (9-5.33)/ array.length) {
            double z = cbrt(x * x + 4.5);
            if(i<array.length) {
                array[i]=z;
                i++;
            }
        }
        output(array, 5);
        outputResult(array, 5);
    }

    private static void output(double[] array, int colCount) {
        System.out.println("Массив A[] ");
        for (int i = 0; i < array.length; i++) {
            System.out.printf("B[ %d ] = %f  ", i, array[i]);
            if ((i + 1) % colCount == 0 || (i + 1) % array.length == 0) System.out.println();
        }
    }

    private static void outputResult(double[] array, int colCount) {
        int count = 0;
        double sum = 1;
        System.out.println();
        System.out.print("Массив B[] из элементов массива A > 3.5 ");
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 3.5) {
                System.out.printf("B[ %d ] = %5.4f  ", count, array[i]);
                count++;
                sum *= array[i];
            }
            if (count % colCount == 0 || count % array.length == 0) System.out.println();
        }
        double srGeom = pow(sum, (double) 1 / count);
        System.out.println();
        System.out.printf("Среднее геометрическое элементов > 3.5 = %f", srGeom);
    }
}
