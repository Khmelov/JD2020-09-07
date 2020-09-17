package by.it.kulik.training.epam;

import java.util.Scanner;

public class Training2 {
        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x, y;
        System.out.println("Enter x:");
        x = scanner.nextInt();
        System.out.println("Enter y:");
        y = scanner.nextInt();
        if (x<4 && x>-4 && y>-3 && y<0){
            System.out.println("True");}
            else if (x<2 && x>-2 && y>0 && y<4){
                System.out.println("True");}
                else {
                    System.out.println("False");
                }
            }
        }

