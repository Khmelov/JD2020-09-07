package by.it.trukhanovich.jd01_02;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        step1();
        int month = scan.nextInt();
        //     System.out.println(month);
        step2(month);
        double a = scan.nextInt();
        double b = scan.nextInt();
        double c = scan.nextInt();
        step3 (a, b, c);

    }

    private static void step1() {
        int[] arr = new int[25];
        for (int i = 0; i < 25; i++) {
            arr[i] = i + 1;
        }
        for (int i = 0; i < 25; i++) {
            if (arr[i] % 5 == 0) System.out.println(arr[i] + " ");
            else System.out.print(arr[i] + " ");
        }
    }


   private static void step3(double a, double b, double c) {
       double discriminant = (b * b) - (4 * a * c);
       double sqrtd = Math.sqrt(discriminant);
       if (discriminant > 0) {
           double x1 = (-b + sqrtd) / (2 * a);
           double x2 = (-b - sqrtd) / (2 * a);
           System.out.println(x1 + " " + x2);
       }
       if (discriminant == 0) {
           double x1 = (-b) / (2 * a);
           System.out.println(x1);
       }
       if (discriminant < 0) {
           System.out.println("корней нет");
       }
   }

    public static void step2(int month) {
        switch (month) {
            case 1:
                System.out.println("январь");
                break;
            case 2:
                System.out.println("февраль");
                break;
            case 3:
                System.out.println("март");
                break;
            case 4:
                System.out.println("апрель");
                break;
            case 5:
                System.out.println("май");break;
            case 6:
                System.out.println("июнь");break;
            case 7:
                System.out.println("июль");break;
            case 8:
                System.out.println("август");break;
            case 9:
                System.out.println("сентябрь");break;
            case 10:
                System.out.println("октябрь");break;
            case 11:
                System.out.println("ноябрь");break;
            case 12:
                System.out.println("декабрь");break;
            default:
                System.out.println("нет такого месяца");
        }
    }
}






