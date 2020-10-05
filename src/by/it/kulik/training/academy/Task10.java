package by.it.kulik.training.academy;

import java.util.Scanner;

class Task10 {
    public static void main(String[] args) {
        int a,b,c,d,e,f;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Сторона первого дома a:");
        a=scanner.nextInt();
        System.out.println("Сторона первого дома b:");
        b=scanner.nextInt();
        System.out.println("Сторона второго дома c:");
        c=scanner.nextInt();
        System.out.println("Сторона второго дома d:");
        d=scanner.nextInt();
        System.out.println("Сторона участка e:");
        e=scanner.nextInt();
        System.out.println("Сторона участка f:");
        f=scanner.nextInt();
        if ((a+c)<e && (b+d)<f){
            System.out.println("Помещаются");
        }
        else System.out.println("Не помещаются");
    }
}
