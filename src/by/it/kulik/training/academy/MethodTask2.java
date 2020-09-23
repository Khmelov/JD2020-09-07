package by.it.kulik.training.academy;

import java.util.Scanner;

public class MethodTask2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        method(a,b);
    }

    static int method(int a, int b) {
        int c = a + b;
        int sum = c + a * b;
        System.out.println(sum);
        return sum;
    }

}
