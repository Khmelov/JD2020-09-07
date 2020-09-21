package by.it.stefankin.jd01_02;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int v = sc.nextInt();
    step1(v);

    }

    public static int[ ][ ] step1(int n) {
    int[][] matr =new int[n][n];
       /* boolean est=false;
        boolean est2=false;
        boolean snado=false;

    do {
       */

     for (int i=0;i<n;i++) {
        for (int j=0;j<n;j++) {
            matr[i][j]=(int) (Math.random()*((2*n)+1)-(n+1));
        }
      }
     /*for (int c=0;c<n;c++) {
        for (int k=0;k<n;k++){
            if (matr[c][k]==n)
                est=true;
            if (matr[c][k]==-n)
                est2=true;
            if (est&&est2)
                snado=true;

        }
     }
    }
     while (!snado); */
     for (int strok=0;strok<n;strok++) {
         for (int stolb = 0; stolb < n; stolb++) {
             System.out.print(matr[strok][stolb] + " ");
             if (stolb==n-1) System.out.print("\n");
         }
     }
    return matr;

    }

 /*
    public static int step2 (int[ ][ ] arr) {

    }
    public static int[ ][ ] step3(int[ ][ ] arr) {

    }

*/
}
