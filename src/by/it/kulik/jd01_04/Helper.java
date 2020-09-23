package by.it.kulik.jd01_04;

import java.util.Arrays;

public class Helper {
    static double findMin(double[ ] arr) {
        double min =  arr[0];
        for (double element : arr)
            if (min > element) {
                min = element;

            }
        System.out.println(min);
        return min;
    }
    static double findMax(double[ ] arr) {
        double max = arr[0];
        for (double element : arr)
            if (max < element) {
                max = element;
            }
        System.out.println(max);
        return max;
    }
    static void sort(double[ ] arr){
        boolean swap;
        double last=arr.length-1;
        do {
            swap=false;
            for(int j=0;j<last;j++){
                if(arr[j]>arr[j+1]){
                    double buffer=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=buffer;
                    swap=true;
                }
            }
            last--;
        }
        while (swap);
        System.out.println(Arrays.toString(arr));
    }
    static double[ ] mul(double[ ][ ] matrix, double[ ] vector){
        double[] z=new double[matrix.length];
        for(int i=0; i<matrix.length; i++)
            for (int j=0;j<vector.length;j++)
                z[i]=z[i]+matrix[i][j]*vector[j];
        System.out.println(Arrays.toString(z));
                    return z;
    }
    static double[ ][ ] mul(double[ ][ ] matrixLeft, double[ ][ ] matrixRight){
        double[][] z=new double[matrixLeft.length][matrixRight[0].length];
        for(int i=0; i<matrixLeft.length; i++)
            for (int j=0;j<matrixRight[0].length;j++)
                for(int k=0; k<matrixRight.length;k++)
                    z[i][j]=z[i][j]+matrixLeft[i][k]*matrixRight[k][j];
        System.out.println(z+" ");
                return z;
    }
}
