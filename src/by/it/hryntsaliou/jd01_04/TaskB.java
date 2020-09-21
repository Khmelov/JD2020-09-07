package by.it.hryntsaliou.jd01_04;

import java.util.Scanner;

class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] names = new String[n];
        int[][] money = new int[n][4];
        int[] sum = new int[n];
        for (int i = 0; i < names.length; i++) {
            names[i] = scanner.next();
        }
        int allSum = 0;
        for (int i = 0; i < names.length; i++) {
            System.out.println("Введите зарплату для " + names[i]);
            for (int j = 0; j < 4; j++) {
                money[i][j] = scanner.nextInt();
                sum[i] += money[i][j];
            }
            allSum += sum[i];
        }
        double avgSum = (double) allSum / (4 * n);
        System.out.println("------------------------------------------------------------ \n" +
                "  Фамилия Квартал1   Квартал2   Квартал3   Квартал4   Итого \n" +
                "------------------------------------------------------------ ");
        for (int i = 0; i < names.length; i++) {
            System.out.printf("%8s: %-10d %-10d %-10d %-10d %-5d",
                    names[i], money[i][0], money[i][1], money[i][2], money[i][3], sum[i]);
            System.out.println();
        }
        System.out.print("------------------------------------------------------------ \n");
        System.out.printf("Итого %d \n", allSum);
        System.out.printf("Средняя %-7.4f \n", avgSum);
    }
}
