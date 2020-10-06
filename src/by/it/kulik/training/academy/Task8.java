package by.it.kulik.training.academy;

import java.util.Scanner;


class Task8 {
    public static void main(String[] args) {
        int a;
        int lastNumber;
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextInt();
        lastNumber=a%10;
        switch (lastNumber){
            case 1:
                System.out.println(a+" Рубль");
                break;
            case 2:
                System.out.println(a+" Рубля");
                break;
            case 3:
                System.out.println(a+" Рубля");
                break;
            case 4:
                System.out.println(a+" Рубля");
                break;
            case 5:
                System.out.println(a+" Рублей");
                break;
            case 6:
                System.out.println(a+" Рублей");
                break;
            case 7:
                System.out.println(a+" Рублей");
                break;
            case 8:
                System.out.println(a+" Рублей");
                break;
            case 9:
                System.out.println(a+" Рублей");
                break;
            case 0:
                System.out.println(a+" Рублей");
                break;
        }
    }
}