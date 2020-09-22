package by.it.makovsky.jd01_02;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

    }
     static int[][] step1(int n){
        int[][] array=new int[n][n];
        boolean minOk;
        boolean maxOk;
        do {
            maxOk=false;
            minOk=false;
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    array[i][j]= (int) Math.random()*n-n;
                    if (array[i][j]==n) maxOk=true;
                    if (array[i][j]==-n) minOk=true;
                }
            }
        } while (!minOk || !maxOk);
        return array;
    }
     static int step2(int[][] arr){
        int total=0;
        for (int[] row: arr) {
            boolean firstOk=false;
            boolean secondOk=false;
            int sumRow=0;
            for (int element:row) {
                if (element>0 && !firstOk){
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
}
