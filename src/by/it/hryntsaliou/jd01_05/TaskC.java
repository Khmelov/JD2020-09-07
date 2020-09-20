package by.it.hryntsaliou.jd01_05;


import static java.lang.StrictMath.*;

class TaskC {
    public static void main(String[] args) {
        //step1();
        step2();
    }

    private static void step2() {
        double[] array = new double[30];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (random() * 348 + 103);
        }
        outBegin(array, 5);
        outResult(array, 2);
        //╔  ═ ║  ╗ ╚ ╝ ╣  ╦ ╩  ╬ ║
    }

    private static void outBegin(double[] array, int colCount) {
        int rows = 0;
        System.out.println("Massiv M <index to rows>");
        System.out.println("╔═══════════╦═══════════╦═══════════╦═══════════╦═══════════╗");
        for (int i = 1; i < array.length; i++) {
            System.out.printf("║M[%2d]=%4.1f", i, array[i]);
            if (i % colCount == 0) {
                rows++;
                if ((array.length - 1) % colCount == 0 && i == array.length - 1) {
                    System.out.println("║");
                    System.out.println("╚═══════════╩═══════════╩═══════════╩═══════════╩═══════════╝");
                    return;
                }
                System.out.println("║");
                System.out.println("╠═══════════╬═══════════╬═══════════╬═══════════╬═══════════╣");
            }
        }
        for (int j = 0; j < (rows + 1) * colCount - (array.length - 1); j++) {
            System.out.print("║           ");
        }
        System.out.println("║");
        System.out.println("╚═══════════╩═══════════╩═══════════╩═══════════╩═══════════╝");
    }

    private static void outResult(double[] array, int colCount) {

    }

    private static void step1() {
        double[] array = new double[(int) (random() * 21 + 20)];
        int i = 0;
        for (double x = 5.33; x <= 9; x += (9 - 5.33) / array.length) {
            double z = cbrt(x * x + 4.5);
            if (i < array.length) {
                array[i] = z;
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
        System.out.println("Массив B[] из элементов массива A > 3.5 ");
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 3.5) {
                System.out.printf("B[ %d ] = %5.4f  ", count, array[i]);
                count++;
                sum *= array[i];
                if (count % colCount == 0 || count % array.length == 0) System.out.println();
            }

        }
        double srGeom = pow(sum, (double) 1 / count);
        System.out.println();
        System.out.printf("Среднее геометрическое элементов > 3.5 = %f", srGeom);
    }
}
