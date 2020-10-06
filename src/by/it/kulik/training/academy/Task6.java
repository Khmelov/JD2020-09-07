package by.it.kulik.training.academy;

import java.util.Scanner;

 class Task6 {
    public static void main(String[] args) {
        int number;
        Scanner scanner=new Scanner(System.in);
        number= scanner.nextInt();
System.out.println(poisk(number));

    }

    private static boolean poisk(int number) {
        if (String.valueOf(number).endsWith("7")){
            return true;
        }
        return false;
    }
}
