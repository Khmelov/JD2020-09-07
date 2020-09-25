package by.it.tarasevich.jd01_03;

public class Utils {

    public static int MaxIntArray(double[] mas) {
        if (0 == mas.length) {
            return Integer.MAX_VALUE;

        } else {

            double max = mas[0];
            for (double m : mas) {
                if (max < m) max = m;
            }
            return (int) max;
        }


    }

    public static int MinIntArray(double[] mas) {
        if (0 == mas.length) {
            return Integer.MIN_VALUE;

        } else {

            double min = mas[0];
            for (double m : mas) {
                if (min > m) min = m;
            }
            return (int) min;
        }


    }

    public static void sortIntArray(double[] array, boolean upDirection) {
        for (int start = 0; start < array.length; start++) {
            int least = start;
            for (int j = start; j < array.length; j++) {
                if ((upDirection && array[j] < array[least]) ||
                        (!upDirection && array[j] > array[least])) {
                    least = j;
                }

            }
            double tmp = array[start];
            array[start] = array[least];
            array[least] = tmp;
        }

    }

    public static double[] arrayMulVector(double[][] x, double[] y) {
        double[] z = new double[x.length];

        for (int i = 0; i < y.length; i++)
            for (int j = 0; j < y.length; j++)
                z[i] = z[i] + x[i][j] * y[j];
        return z;

    }

    public static double[][] arrayMulVector(double[][] x, double[][] y) {
        double[][] z = new double[x.length][y[0].length];

        for (int i = 0; i < x.length; i++)
            for (int j = 0; j < y[0].length; j++)
                for (int k = 0; k < y.length; k++)
                    z[i][j] = z[i][j] + x[i][k] * y[k][j];
        return z;

    }

    public static void arrayPrint2D(double[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++)
                System.out.printf("%6.2f ", m[i][j]);
            System.out.println();
        }

    }

    public static void arrayPrint2D(double[][] m, String name) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++)
                System.out.printf("[%1d,%1d]=%-6.1f ", i, j, m[i][j]);
            System.out.println();
        }
    }
}
