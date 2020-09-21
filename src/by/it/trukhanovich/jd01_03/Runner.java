package by.it.trukhanovich.jd01_03;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String arr= scan.nextLine();
        double[] doubleArray = InOut.getArray(arr);
        InOut.printArray(doubleArray);
        InOut.printArray(doubleArray, "V",3 );
        double max = Helper.findMax(doubleArray);
        System.out.println("max="+max);
        double min = Helper.findMin(doubleArray);
        System.out.println("min="+min);
        Helper.sort(doubleArray);
        System.out.println("сротированный массив");
        InOut.printArray(doubleArray);
        double [][] matrix1=new double[3][3];
        InOut.MassivFilling(matrix1);
        double [][] matrix2=new double[3][2];
        InOut.MassivFilling(matrix2);
        double [] vector= new double[3];
        InOut.MassivFilling(vector);
        System.out.println("matrix1:");
        InOut.printArray(matrix1);
        System.out.println("matrix2:");
        InOut.printArray(matrix2);
        System.out.println("vector:");
        InOut.printArray(vector);
        double[] print1 = Helper.mul(matrix1, vector);
        double[][] print2 = Helper.mul(matrix1, matrix2);
        System.out.println("matrix1*vector:");
        InOut.printArray(print1);
        System.out.println("matrix1*matrix2:");
        InOut.printArray(print2);
    }
}
