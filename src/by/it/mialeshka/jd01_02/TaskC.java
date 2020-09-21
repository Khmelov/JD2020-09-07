package by.it.mialeshka.jd01_02;

import java.util.Scanner;

public class TaskC {
    private static int[][] carr;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[][] = new int[n][n];
        arr = step1(n);
        int s2 = step2(carr);

    }

     static int[][] step1(int n) {
        int result[][] = new int[n][n];
        boolean isn = false;
        boolean isnn = false;
        do{
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                  result[i][j] = (int) Math.round((Math.random() * (2 * n)) - n);
                 if (result[i][j] == n)
                        isn = true;

                 if (result[i][j] == (n*-1))
                       isnn = true;
             }
         }
        } while (!(isn) || !(isnn));


            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(result[i][j] + " ");
                }
                System.out.print("\n");
            }
            return result;
    }

     static int step2(int[][] arr) {
        int result = 0;
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
                int index1 = -1;
                int index2 = -1;
                for (int j = 0; j < arr[0].length; j++) {
                    if ((arr[i][j] > 0) && (index2 == -1) && (index1 >= 0))
                        index2 = j;

                    if ((arr[i][j] > 0) && (index1 == -1))
                        index1 = j;
                }
                if ((index1 > -1) && (index2 > -1)) {
                    for (int k = index1 + 1; k < index2; k++) {
                        result = result + arr[i][k];
                    }
                }
            }
            System.out.println(result);
        }

        return result;
    }


    public TaskC(int[][] m) {
      carr = m;
    }


}
