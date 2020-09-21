package by.it.tarasevich.jd01_02;


import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[][] arr = step1(n);
        step2(arr);
        step3(arr);


    }


    static int[][] step1(int n) {
        boolean minOK;
        boolean maxOK;
        int[][] array = new int[n][n];
        do {
            minOK = false;
            maxOK = false;
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    array[i][j] = -n + (int) (Math.random() * (2 * n + 1));
                    if (array[i][j] == n) maxOK = true;
                    if (array[i][j] == -n) minOK = true;
                }
            }
        } while (!maxOK || !minOK);
        return array;
    }

    static int step2(int[][] arr) {
        int total = 0;
        for (int[] row : arr) {
            boolean firstOK = false;
            int sumRow = 0;
            for (int element : row) {
                if (element > 0 && !firstOK) {
                    firstOK = true;

                }
                if (firstOK && element >= 0) {
                    sumRow += element;
                } else
                    break;
            }
            total += sumRow;

        } System.out.println("total = "+ total);

        return total;
    }


    static int[][] step3(int[][] array) {
        boolean minOK;
        boolean maxOK;

        do {
            maxOK = false;
            minOK = false;
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length; j++) {



                }

            }
            return array;


        } while (!minOK || !maxOK);
    }


}






