package by.it.adryneuski.jd01_02;

import java.util.Random;
import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        //step1(n);

        step2(step1(n));
        // step3(step1(n));

    }

    static int[][] step1(int n) {
        int arr[][] = new int[n][n];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (int) (Math.random() * (2 * n + 1)) - n;
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();

        }
        return arr;

    }

    static int step2(int[][] arr) {
        int c = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length - 1; j++) {
                if ((arr[i][j] > 0) && (arr[i][j + 1] < 0)) c += arr[i][j + 1];
            }
        }           //else { }

        System.out.println(c);
        return c;
    }

//    static int[][] step3(int[][] arr)
//    {
//        int max = 0;
//
//        for (int i = 0; i < arr.length; i++)
//        {
//            for (int j = 0; j < arr[i].length; j++)
//            {
//                if (max < arr[i][j])
//                {
//                    max = arr[i][j];
//                }
//            }
//            System.out.println(max);
//
//            int [][] barr = new int[][];
//            int k=0;
//
//            for (int i = 0; i < arr.length; i++)
//            {
//                for (int j = 0; j < arr[i].length; j++)
//                {
//                    if (arr[i][j]!=max)
//                    {
//                        barr[i][k]=barr[i][j];
//                        k++;
//                    }
//                }
//              k=0;
//
//        }
//
//    }
//

}
