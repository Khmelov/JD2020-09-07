package by.it.kulik.training.academy;

import java.util.Scanner;

 class MethodTask5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество секунд:");
        int a = scanner.nextInt();
        method(a);

    }

    static void method(int a) {
        int sec = a % 60;
        int m = (a - sec) / 60;
        int min = m % 60;
        int h = (m - min) / 60;
        int d=h%24;
        int dayzz=(h-d)/24;
        System.out.println(dayzz+ " дней " + d + " часов " + min + " минут " + sec + " секунд ");

    }

}