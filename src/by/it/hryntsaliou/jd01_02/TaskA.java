package by.it.hryntsaliou.jd01_02;

import java.util.Scanner;

class TaskA {
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

    private static void step3(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int element : arr) {
            if (element < min) min = element;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == min) System.out.print(i + " ");
        }
    }

    private static void step2(int[] arr) {
        double sum = 0;
        for (int element : arr) {
            sum += element;
        }
        double avg = sum / arr.length;
        for (int element : arr) {
            if (element < avg)
                System.out.println(element);
        }
    }

    private static void step1(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int element : arr) {
            if (max < element) max = element;
            if (min > element) min = element;
        }
        System.out.println(min + " " + max);
    }
}
