package by.it.adryneuski.jd01_02;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();

        int[][] arr = {{18, 65, 18, 65, 6}, {22, 28, 45, 9, 12}, {12, 45, 45, 3, 14}, {12, 45, 65, 5, 4}, {12, 45, 65, 5, 4}};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {

                System.out.print(arr[i][j] + " ");
            }
            System.out.println();

        }

        int max = 0;
        int count =0;

        int row =0;
        int col =0;


        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (max < arr[i][j]) {
                    max = arr[i][j];
                    row =i;
                    col = j;
                }
            }

        }
            System.out.println(max);
//////////////////////////////////////////////////
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[i].length; j++)
                if (max == arr[i][j])
                {
                    count++;
                }
        System.out.println(count);
//////////////////////////////////////////////
       


    }
}