package by.it.hryntsaliou.jd01_03;

import java.util.Arrays;

class Helper {
    static double findMin(double[] arr) {
        double min = Double.MAX_VALUE;
        for (double element : arr) {
            if (element < min) min = element;
        }
        System.out.println("MIN = " + min);
        return min;
    }

    static double findMax(double[] arr) {
        double max = Double.MIN_VALUE;
        for (double element : arr) {
            if (element > max) max = element;
        }
        System.out.println("MAX = " + max);
        return max;
    }

    static void sort(double[] arr) {
        Arrays.sort(arr);
        InOut.printArray(arr, "A", 3);
        System.out.println();
    }

    static double[] mul(double[][] matrix, double[] vector) {
        double[] result = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                result[i] = result[i] + matrix[i][j] * vector[j];
            }
        }
        InOut.printMatrixAndVector(matrix, vector, result);
        return result;
    }

    static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {
        double[][] result = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    result[i][j] = result[i][j] + matrixLeft[i][k] * matrixRight[k][j];
                }
            }
        }
        return result;
    }
}
