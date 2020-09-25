package by.it.kulik.jd01_02;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class TaskC {
    public static void main(String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int[][] arr = step1(n);
        System.out.println(Arrays.toString(arr));
    }
        private static int[][] step1(int n){
            int arr[][] = new int[n][n];
            Random random = new Random();
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    arr[i][j] = random.nextInt(n);
                }
            }
                return arr;

            }

        }









