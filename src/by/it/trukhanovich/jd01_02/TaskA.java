package by.it.trukhanovich.jd01_02;

import java.util.Scanner;

public class TaskA {

    public static final int INT = 10;

    public static void main(String[] args) {
        int[] arr = new int[INT];
        Scanner scanner= new Scanner(System.in);
        for (int i=0; i < arr.length; i++  ){
            arr[i]= scanner.nextInt();
        }
        step1(arr);
        step2(arr);
        step3(arr);
    }

    private static void step1(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int element : arr ) {
            if (max<element) max = element;
            if (min > element)  min= element;
            }
        System.out.println( min + " " + max);
        }

    private static void step2(int[] arr) {
        double sum=0;
        for (int element : arr ) {
            sum+=element;
        }
        double cp= sum/INT;
        for (int element : arr ) {
            if (element < cp) System.out.print( element+ " ");
        }
    }

    private static void step3(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int element : arr ) {
            if (min > element)  min= element;
        }
        for (int i=INT-1; i>=0; i-- ) {
           if (arr[i] == min) System.out.print( i + " ");;
        }

    }

}
