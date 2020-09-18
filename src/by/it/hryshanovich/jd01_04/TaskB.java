package by.it.hryshanovich.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите количество людей: ");
        int n = scan.nextInt();
        String[] surname = new String[n];
        System.out.println("Введите фамилии: ");
        getSurname(scan, surname);
        int[][] salary = new int[n][4];
        getSalary(scan, surname, salary);

        int allResult=0;
        for (int i = 0; i < salary.length; i++) {
            System.out.printf("%9s  ", surname[i]);
            int result=0;
            for (int j = 0; j < salary[i].length; j++) {
                result=salary[i][j]+result;
                System.out.printf("%-10d", salary[i][j]);
            }
            System.out.printf("%-10d", result);
            System.out.println();
            allResult=allResult+result;
        }
        inResult(n, allResult);
    }

    private static void inResult(int n, int allResult) {
        System.out.printf("Итого %-10d"+"\n", allResult);
        double averageSalary=(double) allResult /(4* n);
        System.out.printf("Средняя %-10.4f", averageSalary );
    }

    private static void getSalary(Scanner scan, String[] surname, int[][] salary) {
        for (int i = 0; i < salary.length; i++) {
            System.out.println("Введите зарплату для " + surname[i]);
            for (int j = 0; j < salary[i].length; j++) {
                salary[i][j] = scan.nextInt();
            }
        }
    }

    private static void getSurname(Scanner scan, String[] surname) {
        for (int i = 0; i < surname.length; i++) {
            surname[i] = scan.next();
        }
    }
}