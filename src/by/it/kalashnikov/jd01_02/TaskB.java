package by.it.kalashnikov.jd01_02;

import java.util.Arrays;
import java.util.Scanner;

 class TaskB {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter month");
        int month = sc.nextInt();
        System.out.println("Enter a");
        double a=sc.nextDouble();
        System.out.println("Enter b");
        double b=sc.nextDouble();
        System.out.println("Enter c");
        double c=sc.nextDouble();

        step1();
        step2(month);
        step3(a,b,c);

    }


    private static void step1() {
        int[][] array = {
                { 1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16,17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };
        for (int i = 0; i < array.length; i++) {
            System.out.println();
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]+" ");
            }
        }


    }

    private static void step2(int month){
        switch (month) {
            case 1: System.out.println("январь");
                break;
            case 2: System.out.println("февраль");
                break;
            case 3: System.out.println("март");
                break;
            case 4: System.out.println("апрель");
                break;
            case 5: System.out.println("май");
                break;
            case 6: System.out.println("июнь");
                break;
            case 7: System.out.println("июль");
                break;
            case 8: System.out.println("август");
                break;
            case 9: System.out.println("сентябрь");
                break;
            case 10: System.out.println("октябрь");
                break;
            case 11: System.out.println("ноябрь");
                break;
            case 12: System.out.println("декабрь");
                break;
            default: System.out.println("нет такого месяца");
        }
    }

    private static void step3(double a, double b, double c){
        double D = b * b - 4 * a * c;
        if (D > 0) {
            double x1 = (-b - Math.sqrt(D)) / (2 * a);
            double x2 = (-b + Math.sqrt(D)) / (2 * a);
            System.out.println("x1 = " + x1 + ", x2 = " + x2);
        }
        else if (D == 0) {
            double x= -b / (2 * a);
            System.out.println("x = " + x);
        }
        else {
            System.out.println("корней нет");
        }


    }
}
