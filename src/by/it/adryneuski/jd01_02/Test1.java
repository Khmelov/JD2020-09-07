package by.it.adryneuski.jd01_02;

public class Test1 {
    public static void main(String[] args) {

        int[][] arr = {{8, 6, -8, -5, 6}, {2, -2, 4, 9, 12}, {7, -5, -6, 3, 4}, {-2, -4, 6, -3, 4}, {4, -4, -5, -5, 4}};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {

                System.out.print(arr[i][j] + " ");
            }
            System.out.println();

        }

        int c = 0;

        for (int i = 0; i < arr.length; i++)  {
            for (int j = 0; j < arr[i].length - 1; j++)  {

                if ((arr[i][j] > 0) && (arr[i][j + 1] < 0)) c += arr[i][j + 1];
            }}

                //else if ((arr[i][j] > 0) && (arr[i][j + 1] < 0))

        System.out.println(c);





     }
    }
