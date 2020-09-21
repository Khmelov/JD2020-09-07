package by.it.shkatula.jd01_02;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
        arr[i] = scanner.nextInt();    
        }
        step1(arr);
        step2(arr);
        step3(arr);
    }

    private static void step1(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        for (int i : arr) {
            if (min > i) min = i;
            if (max < i) max = i;
        }
        System.out.println(min+" "+max);
        }


    private static void step2(int[] arr) {
        double avg = 0;
        for (int i : arr) {
            avg = avg +i;
        }
        avg = avg/ arr.length;
        for (int i : arr) {
            if(i < avg)
            System.out.print(i+" ");

        }

    }

    private static void step3(int[] arr) {
        int min = arr[0];
        for (int i : arr) {
            if (min>i) min = i;
        }
        for (int b = arr.length-1; b >=0; b--) {
            if (arr[b] == min)
                System.out.print(b+" ");
        }
    }
}
