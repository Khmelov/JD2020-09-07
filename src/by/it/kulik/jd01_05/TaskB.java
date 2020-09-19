package by.it.kulik.jd01_05;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        
    
    Scanner scanner=new Scanner(System.in);
    double x = scanner.nextDouble();
    double y=0;
        for(double i=x-1; i<=6; i++){
            double a=0;
            while (a<=2) {
                a = a + 0.2;
                y=y+Math.pow(7, a) - Math.cos(x);
                System.out.printf("При а=%6.2f x=%6.2f Сумма y=%g\n", a, x, y);

            }

        }
}
}