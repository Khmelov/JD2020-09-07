package by.it.drugov.jd01_04;

import java.util.Scanner;

 class TaskB {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        String[] arrayName = getName(scanner, rows);
        int[][] salary = getSalary(rows, arrayName, scanner);
        printInfo(arrayName, salary,rows);
    }

    static String[] getName(Scanner scanner, int rows) {
        String[] arrayName = new String[rows];
        for (int i = 0; i < arrayName.length; i++) {
            arrayName[i] = scanner.next();
        }
        return arrayName;
    }

    static int[][] getSalary(int rows, String[] arrayName, Scanner scanner) {
        int[][] salary = new int[rows][4];
        for (int i = 0; i < rows; i++) {
            System.out.printf("Введите зарплату для %s \n", arrayName[i]);
            for (int j = 0; j < 4; j++) {
                salary[i][j] = scanner.nextInt();
            }
        }
        return salary;
    }

    static void printInfo(String[] arrayName, int[][] salary,int rows) {
        System.out.println("---------------------------------------------------------");
        System.out.println("Фамилия  Квартал1  Квартал2  Квартал3  Квартал4  Итого");
        System.out.println("----------------------------------------------------------");
        int totalPerson = 0;
        int totalAll = 0;
        double average;
        for (int i = 0; i < arrayName.length; i++) {
            System.out.printf("%7s: ", arrayName[i]);
            for (int j = 0; j < 4; j++) {
                System.out.printf("%-10d", salary[i][j]);
                totalPerson += salary[i][j];
                totalAll += salary[i][j];
                if (j == 3) {
                    System.out.printf("%-5d \n", totalPerson);
                }
            }
            totalPerson = 0;
        }
        System.out.printf("Итого    %d \n", totalAll);
        average = (double) totalAll / rows / 4;
        System.out.printf("Средняя  %-7.4f \n", average);
    }
}
