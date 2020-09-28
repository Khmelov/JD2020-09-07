package by.it.yatsevich.jd01_02;

import java.util.Arrays;
import java.util.Scanner;

class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        step1(n);
        int[][] matrix = {{1, -2, -2, 6}, {-1, 2, -2, 2}, {-2, -2, -6, -2}, {1, 2, -2, 6}};
        step2(matrix);
        //System.out.println(total);
        step3(matrix);
        int[][] result = step3(matrix);
        printResult(result);
    }

    static int[][] step1(int n) {
        int arr[][] = new int[n][n];
        if (arr.length > 0) {
            boolean maxOk, minOk;
            do {
                maxOk = minOk = false;
                for (int i = 0; i < arr.length; i++) {
                    for (int j = 0; j < arr[i].length; j++) {
                        arr[i][j] = -n + (int) (Math.random() * (2 * n + 1));
                        if (arr[i][j] == n) maxOk = true;
                        if (arr[i][j] == -n) minOk = true;
                    }
                }
            } while (!maxOk || !minOk);
            printResult(arr);
            return arr;
        } else System.out.println("нулевая длинна");
        return arr;
    }

    static int step2(int[][] arr) {
        int total=0;
        for (int[] line : arr) {
            int sumLine = 0;
            for (int i = 0; i < line.length - 1; i++) {
                if (line[i] > 0) {
                    do {
                        i++;
                        if (line[i] <= 0) sumLine += line[i];
                        else break;
                    } while (i < line.length - 1);
                }
                total += sumLine;
            }
        }System.out.println(total);
        return total;
    }

    static int[][] step3(int[][] arr) {
        int max = getMax(arr);
        boolean[] delLine = new boolean[arr.length];
        boolean[] delCol = new boolean[arr[0].length];
        buildBoolArray(arr, max, delLine, delCol);
        int colls = 0;
        int lines = 0;
        for (boolean coll : delCol) if (!coll) colls++;
        for (boolean line : delLine) if (!line) lines++;
        int[][] result = getResult(arr, delLine, delCol, lines, colls);
        return result;
    }

    private static int getMax(int[][] arr) {
        int max = Integer.MIN_VALUE;
        for (int[] line : arr) {
            for (int i = 0; i < arr.length; i++) {
                if (max < line[i]) {
                    max = line[i];
                }
            }
        }
        return max;
    }

    private static void buildBoolArray(int[][] arr, int max, boolean[] delLine, boolean[] delCol) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == max) {
                    delLine[i] = true;
                    delCol[j] = true;
                }
            }
        }
    }

    private static int[][] getResult(int[][] arr, boolean[] delLine, boolean[] delCol, int lines, int colls) {
        int[][] result = new int[lines][colls];
        int iR = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!delLine[i]) {
                int jR = 0;
                for (int j = 0; j < arr[i].length; j++) {
                    if (!delCol[j]) {
                        result[iR][jR] = arr[i][j];
                        jR++;
                    }
                }
                iR++;
            }
        }
        return result;
    }

    private static void printResult(int[][] result) {
        for (int i = 0; i < result.length ; i++) {
            System.out.print("\n");
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j]+" ");
            }
        }
        System.out.println("\n");
    }
}