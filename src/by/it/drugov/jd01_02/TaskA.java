package by.it.drugov.jd01_02;

import java.util.Scanner;

 class TaskA {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         int[] array = new int[10];
         for (int i = 0; i < array.length; i++) {
             array[i] = scanner.nextInt();
             step1(array);
             step2(array);
             step3(array);
        }
    }

     static void step3(int[] array) {
        int min = Integer.MAX_VALUE;
         for (int i = 0; i < array.length; i++) {
             if ( array[i]<min) {
                 min = array[i];
             }
         }
         for (int i =array.length - 1; i >=0 ; i--) {
             if(array[i] == min) {
                 System.out.print(i+" ");
             }
         }
    }

    static void step2(int[] array) {
        double sum = 0;
        double average;
         for (int i = 0; i < array.length; i++) {
             sum+=array[i];
         }
         average = sum/ array.length;
         for (int i = 0; i < array.length; i++) {
             if(array[i]<average) {
                 System.out.println(array[i]+" ");
             }
         }
    }

    static void step1( int array[]) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if(array[i]<min) {
                min = array[i];
            }
            if(array[i]>max) {
                max = array[i];
            }
        }
        System.out.println(min+" "+max);
    }
}
