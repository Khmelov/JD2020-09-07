package by.it.hryntsaliou.jd01_02;

import java.util.Scanner;

class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        step1(n);
        int[][] array2 = new int[n][n];
        for (int i = 0; i < array2.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                array2[i][j] = (int) (Math.random() * 2 * (n + 1)) - n;
            }
        }
        step2(array2);
        step3(array2);
    }

    private static int[][] step3(int[][] array) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i][j] > max) max = array[i][j];
            }
        }
        boolean[] delCol = new boolean[array.length];
        boolean[] delRow = new boolean[array[0].length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == max) {
                    delRow[i] = true;
                    delCol[j] = true;
                }
            }
        }

        int cols = 0;
        int rows = 0;
        for (boolean col : delCol) {
            if (!col) cols++;
        }
        for (boolean row : delRow) {
            if (!row) rows++;
        }
        int[][] res = new int[rows][cols];
        int ir = 0;
        for (int i = 0; i < array.length; i++) {
            if (!delRow[i]) {
                int jr = 0;
                for (int j = 0; j < array[i].length; j++) {
                    if (!delCol[j]) {
                        res[ir][jr] = array[i][j];
                        jr++;
                    }
                }
                ir++;
            }
        }
        return res;
    }


    private static int step2(int[][] array2) {
        int sum = 0;
        int count;
        int count1;
        for (int i = 0; i < array2.length; i++) {
            count = 0;
            count1 = 0;
            for (int j = 0; j < array2.length; j++) {
                if (array2[i][j] > 0) {
                    count = j;
                    break;
                }
            }
            for (int j = count + 1; j < array2.length; j++) {
                if (array2[i][j] > 0) {
                    count1 = j;
                    break;
                }
            }
            for (int j = count + 1; j < count1; j++) {
                sum += array2[i][j];
            }
        }
        return sum;
    }

    private static int[][] step1(int n) {
        int[][] array = new int[n][n];
        int count;
        int count1;
        do {
            count = 0;
            count1 = 0;
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length; j++) {
                    array[i][j] = (int) (Math.random() * 2 * (n + 1)) - n;
                }
            }
            for (int[] ints : array) {
                for (int j = 0; j < array.length; j++) {
                    if (ints[j] == n) count++;
                    if (ints[j] == -n) count1++;
                }
            }
        } while (count == 0 || count1 == 0);
        for (int[] ints : array) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
        return array;
    }
}