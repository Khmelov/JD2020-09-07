package by.it.trukhanovich.jd01.jd01_02;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        System.out.println("Введите размер массива");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[][] = new int[n][n];
        arr=step1(n);
        step2 (arr);
        step3 (arr);

    }

    public static int[][] step1 (int n) {
        System.out.println("step1");
        int array[][] = new int[n][n];
        int b1=0;

//int detector - проверка на наличие максимального и минимального
        for (int detector=0 ; detector == 0; b1++){
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    array[i][j] = (int) (Math.random() * (2 * n + 1)) - n;
                }
            }
            boolean detector1 = false;//проверка наличия максимума в массиве
            boolean detector2 = false;//проверка наличия минимума в массиве
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    if (array[i][j] == n) detector1 = true;
                    if (array[i][j] == -n) detector2 = true;
                }
            }
            if (detector1 == true & detector2 == true) detector = 1;
        }
        for (int a = 0; a < array.length; a++) {
            for (int b = 0; b < array[a].length; b++) {
                System.out.print(array[a][b] + "\t");
            }
            System.out.println();
        }

        return array;
    }

    public static int step2(int[][]arr) {
        System.out.println("step2");
        int sum = 0;
        int sumAll=0;
//подсчет суммы элементов между 1 и 2 положительным элементами в строке
        for (int a = 0; a < arr.length; a++) {
            int det = 0; int det2=0;
            for (int b = 0; b < arr[a].length; b++) {
                if (det == 1 & arr[a][b] <= 0 & det2==0) {sum = sum + arr[a][b];}
                else if (det == 0 & arr[a][b] > 0) {det = 1;}
                else if (det == 1 & arr[a][b] > 0) {det = 0; det2=1;}
                if (det2==1) sumAll=sumAll+sum;
            }

        }
        System.out.println("sum="+sum);
        return sum;
    }

    public static int [][] step3(int[][] arr) {
        System.out.println("step3");
        int max = maxArray(arr);
//подсчет количества максимумов в массиве
        int numberMax=0;
        for (int a = 0; a < arr.length; a++) {
            for (int b = 0; b < arr[a].length; b++) {
                if (max == arr[a][b]) numberMax=numberMax+1;
            }
        }
        System.out.println("max="+ max);
        System.out.println("nuberMax(количество максимумов)="+ numberMax);
        /**
         * массив содержащий координаты максимальных элементов внутри исходного массива
         */
        int [][] coordinate = new int [numberMax][2];
        System.out.println("coordinates:");
        /**
         * заполнение массива с координатами максимума
         */
         fillingArrayCoordinate (arr, coordinate, max);

        System.out.println("coordinates:");
        for (int a = 0; a < coordinate.length; a++) {
            for (int b = 0; b < coordinate[a].length; b++) {
                System.out.print(coordinate[a][b] + "\t");
            }
            System.out.println();
        }
        //Перепишем все строки и столбцы в которых есть max элементами равными max
        for (int a = 0; a < coordinate.length; a++) {
            for (int b = 0; b < 1; b++) {
                for (int c = 0; c < arr.length; c++)
                {
                    arr [ coordinate[a][b] ] [c]= max;
                }
            }
        }
        for (int a = 0; a < coordinate.length; a++) {
            for (int b = 1; b < 2; b++) {
                for (int c = 0; c < arr.length; c++)
                {
                    arr [c][coordinate[a][b]]= max;
                }
            }
        }

        System.out.println("arr измененная:");
        for (int a = 0; a < arr.length; a++) {
            for (int b = 0; b < arr[a].length; b++) {
                System.out.print(arr[a][b] + "\t");
            }
            System.out.println();
        }

        int detector=0; //счетчик внутренний
        int numberColumns=0; //счетчик наружный
        for (int c1 = 0; c1 < arr.length; c1++) {
            for (int c2 = 0; c2 < arr[c1].length; c2++) {
                if (arr [c1][c2]!=max) detector=detector+1;
            }

            if (numberColumns<detector) numberColumns=detector;
            detector=0;
        }
//        System.out.println("количество столбцов det4:"+det4);
        detector=0; //счетчик внутренний
        int numberStrings=0; //счетчик наружный
        for (int c1 = 0; c1 < arr.length; c1++) {
            for (int c2 = 0; c2 < arr[c1].length; c2++) {
                if (arr [c1][c2]!=max) detector=detector+1;
            }

            if (detector!=0) numberStrings=numberStrings+1;
            detector=0;
        }
//        System.out.println("количество строк det6:"+det6);
        int out[][]=new int[numberStrings][numberColumns];
        detector=0;
        int detector2=0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j]!=max) { out[detector][detector2]=arr[i][j]; detector2=detector2+1; if (detector2==numberColumns) {detector2=0; detector=detector+1;} }
            }
        }

        return out;
    }

    /**
     *
     * @param arr исходный массив
     * @param coordinate массив с координатами максимумов в исходном массиве
     * @param max количчество максимумов в массиве
     */
    private static void fillingArrayCoordinate(int[][] arr, int[][] coordinate, int max) {
        int x=0;
        for (int i = 0; i < arr.length; i++) {
            for (int c2 = 0; c2 < arr[i].length; c2++) {
                if (arr[i][c2]==max) { coordinate [x] [0]=i; coordinate [x] [1]=c2; x=x+1; }
            }
        }
    }
    private static int maxArray(int[][] arr) {
        int max = Integer.MIN_VALUE;
         for (int a = 0; a < arr.length; a++) {
            for (int b = 0; b < arr[a].length; b++) {
                if (max < arr[a][b]) max = arr[a][b];
               }
        }
        return max;
    }
}

