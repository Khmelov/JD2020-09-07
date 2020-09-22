package by.it.makovsky.jd01_04;

public class Helper {
    static double findMin(double[ ] arr){
        double min=arr[0];
        for (double v : arr) {
            if (min > v) {
                min = v;
            }
        }
        return min;
    }

    static double findMax(double[ ] arr){
        double max=arr[0];
        for (double v : arr) {
            if (max < v) {
                max = v;
            }
        }
        return max;
    }

    static void sort(double[ ] arr){
        boolean flag;
        double last = arr.length-1;
        do {
            flag=false;
            for (int i = 0; i < last; i++) {
                if(arr[i]>arr[i+1]){
                    double mem=arr[i];
                    arr[i]=arr[i+1];
                    arr[i+1]=mem;
                    flag=true;
                }
            }
            last--;
        }
        while (flag);
    }

    static double[ ] mul(double[ ][ ] matrix, double[ ] vector){
        double [] z=new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                z[i]=z[i]+ matrix[i][j]*vector[j];
            }
        }
        return z;
    }

    static double[ ][ ] mul(double[ ][ ] matrixLeft, double[ ][ ] matrixRight){
        double[][] m=new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j <matrixRight[0].length ; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    m[i][j]=m[i][j]+matrixLeft[i][k]*matrixRight[k][j];
                }
                
            }
        }
        return m;
    }

}

