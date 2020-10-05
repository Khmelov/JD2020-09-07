package by.it.kulik.training.academy;

import java.util.Scanner;

 class MethodTask2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(method(a,b));
    }

   private static int method(int a, int b) {
        return (a+b) + a * b;
    }

}
