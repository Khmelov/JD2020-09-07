package by.it.kalashnikov.jd01_02;

import java.util.Scanner;

 class TaskA {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        step1(arr);
        step2(arr);
        step3(arr);
    }
    private static void step1(int[ ] arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int value : arr) {
            if (min > value) min = value;
            if (max < value) max = value;
        }
        System.out.println(min + " " + max);
    }
    private static void step2(int[ ] arr) {
        double avg=0;
        for (int value : arr) {
            avg= avg+value;
        }
        avg= avg/ arr.length;
        for (int value : arr) {
            if (value<avg)
                System.out.print(value + " ");
        }
    }
    private static void step3(int[ ] arr) {
        int min = Integer.MAX_VALUE;
        for (int value : arr) {
            if (min > value) min = value;
        }
        for (int i =arr.length-1 ; i >=0 ; i--) {
            if (arr[i]==min)
                System.out.print(i+" ");
        }
    }
}
