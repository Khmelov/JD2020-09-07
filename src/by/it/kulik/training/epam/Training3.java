package by.it.kulik.training.epam;

import java.util.Scanner;

public class Training3 {
    public static void main(String[] args) {
        //Даны два угла треугольника (в градусах).
        // Определить, существует ли такой треугольник,
        // и если да, то будет ли он прямоугольным.
        Scanner scanner = new Scanner(System.in);
        double a, b, c;
        System.out.println("Первый угол:");
        a = scanner.nextInt();
        System.out.println("Второй угол:");
        b = scanner.nextInt();
        c = a + b;
        if (c <= 180 && a > 0 && a < 90 || a>90 &&a<180 && b > 0 && b < 90 || b>90 && b<180) {
            System.out.println("Такой треугольник существует");
        } else if (c <= 180 && a == 90 || b == 90 || c == 90 && a > 0 && a < 180 && b > 0 && b < 180) {
            System.out.println("Такой треугольник прямоугольный");
        } else {
            System.out.println("Такого треугольника не существует");

        }
    }
}
