package by.it.kulik.training.academy;


import java.util.Scanner;

 class Task7 {
    public static void main(String[] args) {
        int a,b,r;
        Scanner scanner=new Scanner(System.in);
        a= scanner.nextInt();
        b= scanner.nextInt();
        r= scanner.nextInt();
        if (2*r>Math.sqrt(a*a+b*b)){
            System.out.println("Можно");
        }else System.out.println("Нельзя");
    }
}
