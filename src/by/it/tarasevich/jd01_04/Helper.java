package by.it.tarasevich.jd01_04;

public class Helper {

    public static double findMax(double[] arr) {
        if (0 == arr.length) {
            return Integer.MAX_VALUE;

        } else {

            double max = arr[0];
            for (double m : arr) {
                if (max < m) max = m;
            }
            return max;
        }


    }

    public static double findMin(double[] arr) {
        if (0 == arr.length) {
            return Integer.MIN_VALUE;

        } else {

            double min = arr[0];
            for (double m : arr) {
                if (min > m) min = m;
            }
            return min;
        }


    }

    public static void sort(double[] arr) {
        for (int start = 0; start < arr.length; start++) {
            int least = start;
            for (int j = start; j < arr.length; j++) {
                if ((arr[j] < arr[least]) ||
                        (arr[least] > arr[start])) {
                    least = j;
                }

            }
            double tmp = arr[start];
            arr[start] = arr[least];
            arr[least] = tmp;
        }
    }

    static double[] mul(double[][] matrix, double[] vector) {
        double[] z = new double[matrix.length];

        for (int i = 0; i < vector.length; i++)
            for (int j = 0; j < vector.length; j++)
                z[i] = z[i] + matrix[i][j] * vector[j];
        return z;

    }

    static double[][] mul(double[][] matrixLeft, double[][] matrixRigth) {
        double[][] z = new double[matrixLeft.length][matrixRigth[0].length];

        for (int i = 0; i < matrixLeft.length; i++)
            for (int j = 0; j < matrixRigth[0].length; j++)
                for (int k = 0; k < matrixRigth.length; k++)
                    z[i][j] = z[i][j] + matrixLeft[i][k] * matrixRigth[k][j];
        return z;

    }
}