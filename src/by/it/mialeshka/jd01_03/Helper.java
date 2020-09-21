package by.it.mialeshka.jd01_03;

public class Helper {
    /**
     * @author mialeshka
     * @param arr
     * @return double
     * minimum element of an array
     */
    static double findMin(double[ ] arr){
        double res = Double.MIN_VALUE;
        if(arr.length > 0){
            res = arr[0];
            for (double element : arr) {
                if (res > element)
                    res = element;
            }
        }
        return res;
    }

    /**
     * @author mialeshka
     * @param arr
     * @return double
     * maximum array element
     */
    static double findMax(double[ ] arr) {
        double res = Double.MAX_VALUE;
        if(arr.length > 0){
            res = arr[0];
            for (double element : arr) {
                if (res < element)
                    res = element;
            }
        }
        return res;
    }

    /**
     * @author mialeshka
     * @param arr
     * sort ascending array
     */
    static void sort(double[ ] arr) {
        for (int i = arr.length - 1; i >= 1; i--){
            for (int j = 0; j < i; j ++){
                if(arr[j] > arr[j + 1]){
                    double larger = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = larger;
                }
            }
        }
    }

    /**
     *
     * @param matrix
     * @param vector
     * @return double[]
     * multiplication of a matrix and a vector
     */
    static double[] mul(double[][] matrix, double[] vector) {
        double[] res = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                res[i] = res[i] + matrix[i][j]*vector[j];
            }
        }
        return res;
    }

    /**
     *
     * @param matrixLeft
     * @param matrixRight
     * @return double[][]
     * multiplication of two matrices
     */
    static double[ ][ ] mul(double[ ][ ] matrixLeft, double[ ][ ] matrixRight) {
        double[][] res = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    res[i][j] = res[i][j] + matrixLeft[i][k]*matrixRight[k][j];
                }
                           }
        }
        return res;
    }
}
