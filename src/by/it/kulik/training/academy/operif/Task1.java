package by.it.kulik.training.academy.operif;


import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int r = scanner.nextInt();
        if (r>a*Math.sqrt(2)/2) {
        }else if (r > b * Math.sqrt(2) / 2) {
            System.out.println("Такую дырку можно закрыть картонкой");
        }
            else System.out.println("Такую дырку картонкой не закроешь");
            }
        }
    

