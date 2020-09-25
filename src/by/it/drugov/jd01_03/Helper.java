package by.it.drugov.jd01_03;

import java.util.Scanner;

class Helper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    }

    /**
     * fidnMin находит и возвращает минимальный элемент массива array.
     *
     * @param array принимает одномерный массив чисел типа double.
     * @return minElement возвращает минимальный элемент в массиве array.
     */
    static double findMin(double array[]) {
        double minElement = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < minElement) {
                minElement = array[i];
            }
        }
        return minElement;
    }

    /**
     * findMax находит и возвращает максимальный элемент массива array.
     *
     * @param array принимает одномерный массив чисел типа double.
     * @return maxElement возвращает максимальный элемент в массиве array.
     */
    static double findMax(double array[]) {
        double maxElement = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > maxElement) {
                maxElement = array[i];
            }
        }
        return maxElement;
    }

    /**
     * sort производит сортировку входного одномерного массива array методом пузырька.
     *
     * @param array входной одномерный массив чисел типа double
     */
    static void sort(double array[]) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    double temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    /**
     * mul производит умножение матрицы на вектор
     *
     * @param matrix входной двумерный массив чисел типа double
     * @param vector одномерный массив чисел типа double
     * @return resultVector возвращает результирующий вектор
     */
    static double[] mul(double[][] matrix, double[] vector) {
        double[] resultVector = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                resultVector[i] += matrix[i][j] * vector[j];
            }
        }
        return resultVector;
    }

    /**
     * mul умножает две входные матрицы
     *
     * @param matrixLeft двумерный массив чисел типа double
     * @param matrixRight двумерный массив чисел типа double
     * @return resultMatrix возвращает результирующую матрицу
     */
    static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {
        double[][] resultMatrix = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    resultMatrix[i][j] += matrixLeft[i][k] * matrixRight[k][j];
                }
            }
        }
        return resultMatrix;
    }
}
