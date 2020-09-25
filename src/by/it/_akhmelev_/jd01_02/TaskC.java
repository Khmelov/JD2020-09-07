package by.it._akhmelev_.jd01_02;

import java.util.Arrays;

public class TaskC {

    public static void main(String[] args) {
        int[][] m4 = {{1, -2, -2, 6}, {-1, 2, -2, 2}, {-2, -2, -6, -2}, {1, 2, -2, 6}};
        int[][] res = step3(m4);
        System.out.println(Arrays.deepToString(res));
    }
    static int[ ][ ] step1(int n){
        int[][] array=new int[n][n];
        boolean minOk;
        boolean maxOk;
        do {
            maxOk=false;
            minOk=false;
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    array[i][j]=-n+(int)(Math.random()*(2*n+1));
                    if (array[i][j]==n) maxOk=true;
                    if (array[i][j]==-n) minOk=true;
                }
            }
        } while (!minOk || !maxOk);
        return array;
    }
    static int step2(int[ ][ ] arr){
        int total=0;
        for (int[] row : arr) {
            boolean firstOk=false;
            boolean secondOk=false;
            int sumRow=0;
            for (int element : row) {
                if (element>0 && !firstOk) {
                    firstOk=true;
                }
                if (firstOk && element<=0){
                    sumRow+=element;
                }
                else {
                    secondOk=true;
                    break;
                }

            }
            if (secondOk)
                total+=sumRow;
        }
        return total;
    }

    static int[ ][ ] step3(int[ ][ ] arr){
        //findMax
        int max = getMax(arr);

        boolean[] delRow=new boolean[arr.length];
        boolean[] delCol=new boolean[arr[0].length];
        //buildDelArray
        buildDelArray(arr, max, delRow, delCol);
        //calcSize
        int cols=0;
        int rows=0;
        for (boolean col : delCol) if (!col) cols++;
        for (boolean row : delRow) if (!row) rows++;

        //getResult
        int[][] res = getResult(arr, delRow, delCol, cols, rows);

        return res;
    }

    private static int[][] getResult(int[][] arr, boolean[] delRow, boolean[] delCol, int cols, int rows) {
        int[][] res=new int[rows][cols];
        int ir=0;
        for (int i = 0; i < arr.length; i++) {
            if (!delRow[i]){
                int jr=0;
                for (int j = 0; j < arr[i].length; j++) {
                    if (!delCol[j]){
                        res[ir][jr]=arr[i][j];
                        jr++;
                    }
                }
                ir++;
            }
        }
        return res;
    }

    private static void buildDelArray(int[][] arr, int max, boolean[] delRow, boolean[] delCol) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(arr[i][j]==max){
                    delRow[i]=true;
                    delCol[j]=true;
                }
            }
        }
    }

    private static int getMax(int[][] arr) {
        int max=Integer.MIN_VALUE;
        for (int[] row : arr) {
            for (int i = 0; i < arr.length; i++) {
                if (max<row[i]){
                    max=row[i];
                }
            }
        }
        return max;
    }
}
