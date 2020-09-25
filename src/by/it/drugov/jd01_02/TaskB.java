package by.it.drugov.jd01_02;

import java.sql.SQLOutput;
import java.util.Scanner;


 class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int month = scanner.nextInt();
        step1();
        step2(month);
        double a = scanner.nextInt();
        double b = scanner.nextInt();
        double c = scanner.nextInt();
        step3(a,b,c);
    }

    static void step1() {
        int[][] array = new int[5][5];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = 5*i+j+1;
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println();
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j]+" ");
            }
        }
    }

    static void step2(int month) {
        switch(month) {
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
                System.out.println("май");
                break;
            case 6:
                System.out.println("июнь");
                break;
            case 7:
                System.out.println("июль");
                break;
            case 8:
                System.out.println("август");
                break;
            case 9:
                System.out.println("сентябрь");
                break;
            case 10:
                System.out.println("октябрь");
                break;
            case 11:
                System.out.println("ноябрь");
                break;
            case 12:
                System.out.println("декабрь");
                break;
            default:
                System.out.println("нет такого месяца");
        }

    }
    static void step3(double a, double b, double c) {
        double discriminant = Math.pow(b,2) - 4* a *c;
        if(discriminant < 0) {
            System.out.println("корней нет");
        } else if (discriminant == 0) {
            double x1 = (-b - Math.sqrt(discriminant))/(2*a);
                System.out.println(x1);
            }  else {
                double x1 = (-b + Math.sqrt(discriminant))/(2*a);
                double x2 = (-b - Math.sqrt(discriminant))/(2*a);
                System.out.println(x1+" "+x2);
            }
        }

    }

