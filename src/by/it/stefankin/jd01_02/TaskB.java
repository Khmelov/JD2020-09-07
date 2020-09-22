package by.it.stefankin.jd01_02;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vvod = sc.nextInt();
        double a, b, c;
        a = sc.nextDouble();
        b = sc.nextDouble();
        c = sc.nextDouble();

        step1();
        step2(vvod);
        step3(a, b, c);

    }

    private static void step1() {
        int[] mas = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25};
        for (int i = 0; i < mas.length; i++) {

            if (i == 5 || i == 10 || i == 15 || i == 20) {
                System.out.println("\n");
            }
            System.out.print(mas[i] + " ");
        }
    }

    private static void step2(int month) {
        switch (month) {
            case 1:
                System.out.println("\n" + "январь");
                break;
            case 2:
                System.out.println("\n" + "февраль");
                break;
            case 3:
                System.out.println("\n" + "март");
                break;
            case 4:
                System.out.println("\n" + "апрель");
                break;
            case 5:
                System.out.println("\n" + "май");
                break;
            case 6:
                System.out.println("\n" + "июнь");
                break;
            case 7:
                System.out.println("\n" + "июль");
                break;
            case 8:
                System.out.println("\n" + "август");
                break;
            case 9:
                System.out.println("\n" + "сентябрь");
                break;
            case 10:
                System.out.println("\n" + "октябрь");
                break;
            case 11:
                System.out.println("\n" + "ноябрь");
                break;
            case 12:
                System.out.println("\n" + "декабрь");
                break;
            default:
                System.out.println("\n" + "нет такого месяца");
                break;
        }
    }

    private static void step3(double a, double b, double c) {

        double discr, x1, x2;
        discr = b * b - 4 * a * c;
        if (discr > 0) {
            x1 = (-b - Math.sqrt(discr))/(2*a);
            x2 = (-b + Math.sqrt(discr))/(2*a);
            System.out.println("x1 = "+x1+" x2 = "+x2);

        } else if (discr == 0) {
            x1 = -b/(2*a);
            System.out.println("x "+x1);
        }  else
           System.out.println("корней нет");
    }
}
