package by.it.kulik.training.epam;

import java.util.Scanner;

public class Training {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a, b, c, z;
        System.out.println("Enter a:");
        a = scanner.nextInt();
        System.out.println("Enter b:");
        b = scanner.nextInt();
        System.out.println("Enter c:");
        c = scanner.nextInt();
        z=((a-3)*b/2)+c;
        System.out.println("z=" + z);
    }
}
