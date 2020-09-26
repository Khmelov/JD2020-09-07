package by.it.adryneuski.jd01_04;

import java.util.Random;

public class InOut {

    static double[] getArray(String line) {
        String[] strArr = line.split(" ");
        double[] res = new double[strArr.length];

        for (int i = 0; i < res.length; i++) {

            res[i] = Double.parseDouble(strArr[i]);

        }
        return res;

    }

    static void printArray(double[] arr) {

        for (double element : arr) {

            System.out.print(element + " ");

        }
        System.out.println();
    }

    static void printArray(double[] arr, String name, int ColumnCount) {
        for (int i = 0; i < arr.length; i++) {


            System.out.printf("%s[% -3d]=%-2.3f ", name, i, arr[i]);
            if ((i+1)%ColumnCount==0 || i+1==arr.length)
                System.out.println();

        }

    }
    static double[][] printMatrix(int n) {

        Random r = new Random();
        double a[][] = new double [n][n];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {

                a[i][j] = r.nextInt(9);
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        return a;
    }
    static double[] printVector(int n)
      {
          Random r = new Random();
          double b[] = new double [n];

          for (int i = 0; i < b.length; i++)
          {
              b[i] = r.nextInt(9);
              System.out.print(b[i] + " ");
          }

          return b;


      }

}