package by.it.drugov.jd01_02;

import java.util.Scanner;

 class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        step1(n);
        int[][]array = new int[n][n];
        step2(array);
    }

    static int step2(int[][] arr) {
        int sum =0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if((arr[i][j]>0)&&(arr[i][j+1]>0)) {
                    break;
                }
                if(arr[i][j]>0) {
                    while((arr[i][j+1]<0) && (j< arr.length)) {
                        sum+=arr[i][j];
                        j++;
                    }
                }
            }
        }
        System.out.println(sum);
        return sum;
    }

     static int[][] step1(int n) {
        int [][] array = new int[n][n];
        byte flag =0;
        boolean markPos =true;
        boolean markNeg = true;
        while(flag<2) {
            flag =0;
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length; j++) {
                    array[i][j] = (int) (Math.random() * 2 * (n + 1)) - n;
                    if ((array[i][j] == n) &&(markPos)) {
                        flag++;
                        markPos = false;
                    }
                    if((array[i][j]==(-n)) && (markNeg)) {
                        flag++;
                        markNeg = false;
                    }
                }
            }
            if(flag>=2) {
                for (int i = 0; i < array.length; i++) {
                    System.out.println();
                    for (int j = 0; j < array.length; j++) {
                        System.out.print(array[i][j]+" ");
                    }
                }
            }
        }
         return array;
     }
     private static int[][] step3(int[][] array) {
         int max = Integer.MIN_VALUE;
         for (int i = 0; i < array.length; i++) {
             for (int j = 0; j < array.length; j++) {
                 if(array[i][j]>max) max = array[i][j];
             }
         }
         boolean[] delCol = new boolean[array.length];
         boolean[] delRow = new boolean[array[0].length];
         for (int i = 0; i < array.length; i++) {
             for (int j = 0; j < array[i].length; j++) {
                 if(array[i][j] == max) {
                     delRow[i] = true;
                     delCol[j] = true;
                 }
             }
         }

         int cols=0;
         int rows=0;
         for (boolean col : delCol) {
             if(!col) cols++;
         }
         for (boolean row : delRow) {
             if(!row) rows++;
         }
         int[][] res = new int[rows][cols];
         int ir = 0;
         for (int i = 0; i < array.length; i++) {
             if(!delRow[i]) {
                 int jr = 0;
                 for (int j = 0; j < array[i].length; j++) {
                     if (!delCol[j])
                     {
                         res[ir][jr] = array[i][j];
                         jr++;
                     }
                 }
                 ir++;
             }
         }
         return res;
     }
}
