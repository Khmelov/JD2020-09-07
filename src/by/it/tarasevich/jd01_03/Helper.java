package by.it.tarasevich.jd01_03;

public class Helper {

    static double findMax(double[] arr) {
        double max = arr[0];
        for (double element : arr) {

            if (max < element) max = element;
        }
        return max;
    }

    public static double findMin(double[] arr) {
        double min = arr[0];
        for (double element : arr) {

            if (min > element) min = element;
        }
        return min;
    }

    static void sort(double[] arr) {
        int b = arr.length - 1;
        double buf = 0;
        boolean det;
        do {


            det = false;
            for (int i = 0; i < b; i++) {
                if (arr[i] > arr[i + 1]) {
                    buf = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = buf;
                    det = true;
                }
            }
            b--;
        }
        while (det);
    }

    static double[] mul(double[][] matrix, double[] vector) {
        double[] z = new double[matrix.length];
        for (int i = 0; i < vector.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                z[i] = z[i] + matrix[i][j] * vector[j];
            }
        }
        return z;

    }

    static double[][] mul(double[][] matrixLeft, double[][] matrixRigth) {
        double[][] z = new double[matrixLeft.length][matrixRigth[0].length];

        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRigth[0].length; j++) {
                for (int k = 0; k < matrixRigth.length; k++) {
                    z[i][j] = z[i][j] + matrixLeft[i][k] * matrixRigth[k][j];
                }
            }
        }
        return z;

    }
}