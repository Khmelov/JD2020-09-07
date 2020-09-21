package by.it.trukhanovich.jd01_04;

/**
 * класс вспомогательный функций
 */

class Helper {
    /**
@param arr  входящий массив
@return  минимальное значение в массиве
 */
    static double findMin(double[] arr) {
        double min = arr[0];
        for (double element : arr) {
            if (min > element) min = element;
        }
        return min;
    }
    /**
     @param arr  входящий массив
     @return  максимальное значение в массиве
     */
    static double findMax(double[] arr) {
        double max = arr[0];
        for (double element : arr) {
            if (max < element) max = element;
        }
        return max;
    }
    /**
     @param arr  входящий массив
     @return  сортирует массив по возрастанию
     */
    static void sort(double[] arr) {
        int b = arr.length-1;
        double buf = 0;
        boolean det;
        do {
            det=false;
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

    /**
     *
     * @param matrix входящая матрица
     * @param vector входящий вектор
     * @return результат умножения матрицы и вектора
     */
    static double[ ] mul(double[ ][ ] matrix, double[ ] vector){
        double result []=new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                result [i]=result[i]+matrix [i][j]*vector[j];
            }
        }
        return result;
    }

    /**
     *
     * @param matrixLeft входящая матрица
     * @param matrixRight входящая матрица
     * @return результат умножения двух матриц
     */
    static double[ ][ ] mul(double[ ][ ] matrixLeft, double[ ][ ] matrixRight){
        double[][] result = new double[matrixLeft.length][matrixRight[0].length];
            for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    result[i][j]=result[i][j]+matrixLeft[i][k]*matrixRight[k][j];
                    
                }
                
            }
        }
        return result;
        
    }
}