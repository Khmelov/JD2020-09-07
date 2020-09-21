package by.it.drugov.jd01_04;

import java.util.Scanner;

class Helper {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
   }
   static double findMin(double array[]) {
       double minElement=array[0];
       for (int i = 0; i < array.length; i++) {
           if(array[i]<minElement) {
               minElement = array[i];
           }
       }
       return minElement;
   }

   static double findMax(double array[]) {
       double maxElement = array[0];
       for (int i = 0; i < array.length; i++) {
           if(array[i]>maxElement) {
               maxElement = array[i];
           }
       }
       return maxElement;
   }
   static void sort(double array[]) {
       for (int i = 0; i < array.length; i++) {
           for (int j = 0; j < array.length -1 - i; j++) {
               if(array[j]>array[j+1]) {
                   double temp = array[j];
                   array[j] = array[j+1];
                   array[j+1] = temp;
               }
           }
       }
   }

    static double[] mul( double [][] matrix, double[] vector) {
       double [] resultVector = new double[matrix.length];
           for (int i = 0; i < matrix.length; i++) {
               for (int j = 0; j < vector.length; j++) {
                   resultVector[i]+= matrix[i][j]*vector[j];
               }
           }
       return resultVector;
   }
   static double [][] mul (double[][] matrixLeft, double[][] matrixRight) {
       double [][] resultMatrix = new double[matrixLeft.length][matrixRight[0].length];
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
