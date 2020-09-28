package by.it.yatsevich.jd01_04;

import java.util.Arrays;

class Helper {
    static double findMin(double[ ] arr){
        if (0== arr.length){
            return Double.MIN_VALUE;
            }
            else {
                double min = arr[0];
            for (double m: arr) {
                if (min > m) min = m;
            }
            return min;
        }
    }
    static double findMax(double[ ] arr){
        if (0== arr.length){
            return Double.MAX_VALUE;
        }
        else {
            double max = arr[0];
            for (double m: arr) {
                if (max<m) max=m;
            }
            return max;
        }
    }
    static void sort(double[ ] arr){
        System.out.println(Arrays.toString(arr));
        for (int left = 0; left < arr.length; left++) {
            double value= arr[left];
            int i = left-1;
            for (; i >= 0; i--) {
                if (value< arr[i]){
                    arr[i+1]=arr[i];
                } else {
                    break;
                }
            }
            arr[i+1] = value;
        }
        System.out.println(Arrays.toString(arr));
    }
    static double[ ] mul(double[ ][ ] matrix, double[ ] vector){
        double[] res=new double[matrix.length];
        for (int i = 0; i < matrix.length; i++)
            for (int j=0; j<vector.length; j++)
                res[i]= res[i]+matrix[i][j]*vector[j];
        return  res;
    }
    static double[ ][ ] mul(double[ ][ ] matrixLeft, double[ ][ ] matrixRight) {
        double[][] res = new double[matrixLeft.length][matrixRight[0].length]; {
        for (int i = 0; i < matrixLeft.length; i++)
            for (int j = 0; j < matrixRight[0].length; j++)
                for (int k = 0; k < matrixRight.length; k++)
                    res[i][j]=res[i][j]+matrixLeft[i][k]*matrixRight[k][j];
                return res;}


    }
//    static double nulPrint(double [][]mul, String name){
//        for (int i = 0; i < mul.length; i++) {
//            for (int j = 0; j < mul[0].length; j++)
//                System.out.printf(name+"[%1d,%1d]=%-6.1f ",i,j,mul[i][j]);
//            System.out.println();
//        }
//        System.out.println();
//    }

}
