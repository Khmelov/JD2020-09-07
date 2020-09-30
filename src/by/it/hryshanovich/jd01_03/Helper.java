package by.it.hryshanovich.jd01_03;

public class Helper {
    public Helper() {
    }

    static double findMax(double[] arr) {
        if (0 == arr.length) {
            return 1.7976931348623157E308D;
        } else {
            double max = arr[0];
            double[] var3 = arr;
            int var4 = arr.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                double element = var3[var5];
                if (max < element) {
                    max = element;
                }
            }

            return max;
        }
    }

    static double findMin(double[] arr) {
        if (0 == arr.length) {
            return 1.7976931348623157E308D;
        } else {
            double min = arr[0];
            double[] var3 = arr;
            int var4 = arr.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                double element = var3[var5];
                if (min > element) {
                    min = element;
                }
            }

            return min;
        }
    }

    static void sort(double[] arr) {
        for(int i = 0; i < arr.length; ++i) {
            double min = arr[i];
            int min_i = i;

            for(int j = i + 1; j < arr.length; ++j) {
                if (arr[j] < min) {
                    min = arr[j];
                    min_i = j;
                }
            }

            if (i != min_i) {
                double tmp = arr[i];
                arr[i] = arr[min_i];
                arr[min_i] = tmp;
            }
        }

    }

    static double[] mul(double[][] matrix, double[] vector) {
        double[] z = new double[matrix.length];

        for(int i = 0; i < matrix.length; ++i) {
            for(int j = 0; j < vector.length; ++j) {
                z[i] += matrix[i][j] * vector[j];
            }
        }

        return z;
    }

    static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {
        double[][] z = new double[matrixLeft.length][matrixRight[0].length];

        for(int i = 0; i < matrixLeft.length; ++i) {
            for(int j = 0; j < matrixRight[0].length; ++j) {
                for(int k = 0; k < matrixRight.length; ++k) {
                    z[i][j] += matrixLeft[i][k] * matrixRight[k][j];
                }
            }
        }

        return z;
    }
}