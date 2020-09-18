package by.it.stefankin.jd01_03;

public class Helper {

    public static void main(String[] args) {
        double[] mas = new double[] {1,-5,3,7,15,4,8,21,13};
        findMin(mas);
        findMax(mas);
        sort(mas);
        for (double e:mas) {
            System.out.print(e + " ");
        }
        }



    static double findMin(double[ ] arr){
    double min =arr[0];
    for (int i=1; i< arr.length; i++){
        if (min > arr[i])  min=arr[i];
        }
        System.out.println(min);
    return min;
    }


    static double findMax(double[ ] arr){
        double max =arr[0];
        for (int i=1; i< arr.length; i++){
            if (max < arr[i])  max=arr[i];
        }
        System.out.println(max);
        return max;

    }

    static void sort(double[ ] arr) {
        boolean swap;
        int last = arr.length - 1;
        do {
            swap = false;
            for (int i = 0; i < last; i++) {
                if (arr[i] > arr[i + 1]) {
                    double rezerv = arr[i];
                    arr[i]=arr[i+1];
                    arr[i+1] = rezerv;
                    swap = true;
                }

            }
            last--;
        } while (swap);
    }

    static double[ ] mul(double[ ][ ] matrix, double[ ] vector){
        double[] z =new double[matrix.length];
        for (int i=0; i<matrix.length;i++){

            for (int j=0;j< vector.length;j++) {
                z[i]=z[i]+matrix[i][j]*vector[j];
            }
        }
        return z;

    }

    static double[ ][ ] mul(double[ ][ ] matrixLeft, double[ ][ ] matrixRight){
        double[][] z = new double[matrixLeft.length][matrixRight[0].length];
            for (int i=0; i<matrixLeft.length;i++) {
                for (int j=0; j<matrixRight[0].length;j++) {
                    for (int k=0;k<matrixRight.length;k++) {
                        z[i][j] =z[i][j]+matrixLeft[i][k]*matrixRight[k][j];
                    }
                }
            }
        return z;
    }

}
