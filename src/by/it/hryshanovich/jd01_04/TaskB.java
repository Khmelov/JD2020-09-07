package by.it.hryshanovich.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        System.out.println("Введите количество людей: ");
        int n = a.nextInt();
        String[] peoples = new String[n]; //определяем сам массив
        for (int i = 0; i < peoples.length; i++) {
            System.out.println("Введите фамилии: ");
            peoples[i] = a.next(); //вводим фамилии людей
        }
        int[][] mas = new int[n][4];
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                System.out.print("Введите зп для " + " " + peoples[i] + " ");
                mas[i][j] = a.nextInt();
            }
        }
        System.out.println();
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                System.out.printf(mas[i][j] + "\t");
            }
            System.out.println();
        }
        int sum = 0;
        double med = 0;
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                sum += mas[i][j];
                med = sum / (n * 4);
            }
        }
        System.out.println("Итого " + sum);
        System.out.printf("Средняя " + "%-3.4f", med);
    }

}