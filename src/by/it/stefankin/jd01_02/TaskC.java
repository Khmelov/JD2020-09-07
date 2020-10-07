package by.it.stefankin.jd01_02;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int v = sc.nextInt();
    int [][] arr=step1(v);
    step2(arr);
    }

    public static int[ ][ ] step1(int n) {
    int[][] matr =new int[n][n];


    boolean soderzh = true;
    do {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matr[i][j] = (int) Math.round(Math.random() * ((2 * n) + 1) - (n + 1));
            }
        }
        int d1 =-n;
        int d2 =n;
        boolean find1=false;
        boolean find2=false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
               if (matr[i][j] ==d1) find1=true;
               if (matr[i][j] ==d2) find2=true;
            }
        }
        if (find1&&find2) soderzh=false;

    } while (soderzh);
     for (int strok=0;strok<n;strok++) {
         for (int stolb = 0; stolb < n; stolb++) {
             System.out.print(matr[strok][stolb] + " ");
             if (stolb==n-1) System.out.print("\n");
         }
     }
    return matr;

    }


    public static int step2 (int[ ][ ] arr) {
       int sum = 0;

       for (int j=0; j<arr.length;j++) {

           int pol1 = -1;
           int pol2 = -1;
           for (int i = 0; i < arr[j].length; i++) {
               if (arr[j][i] > 0) {
                   pol1 = i;
                   for (int k = pol1 + 1; k < arr[j].length; k++) {
                       if (arr[j][k] > 0)
                           System.out.println("22");
                       pol2 = k;
                       if (pol1 >= 0 && pol2 > 0)
                           System.out.println("индексы"+"="+(pol2-pol1));
                                                            {
                           for (int q = pol1 + 1; q < pol2; q++) {
                              // if (q != pol2)
                                   sum = sum+arr[j][q];
                               System.out.println(sum+"в цикле");
                           }

                       }

                       break;
                   }
                   break;
               }

           }



       }
       System.out.println(sum+ "  итого");
       return sum;
    }

    public static int[ ][ ] step3(int[ ][ ] arr) {
    return null;
    }


}
