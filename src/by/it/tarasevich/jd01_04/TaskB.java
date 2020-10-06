package by.it.tarasevich.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        String[] family = new String[n];
        getFamily(scanner,family);
        int[][] salary = new int[n][4];
        getSelary(scanner,family,salary);


        int allResalt = 0 ;
        for (int i = 0; i < salary.length; i++) {
            System.out.printf("%9s ", family[i]);
            int resault = 0 ;
            for (int j = 0; j <salary[i].length ; j++) {
                resault = salary[i][j] + resault;
                System.out.printf("%-10d", salary[i][j]);

            }
            System.out.printf("%-10d",resault);
            System.out.println();
            allResalt = allResalt+ resault;
        }
        inResault(n, allResalt);


    }

    private static void inResault (int n, int allRresault) {
        System.out.printf("Итого %-10d"+ "\n",allRresault);
        double avSelary = (double)allRresault/(4*n);
        System.out.printf("Средняя %-10.4f", avSelary);
    }

    private static void getSelary(Scanner scanner, String[] family,int[][] selary ) {
        for (int i = 0; i <selary.length ; i++) {
            System.out.println("Введите ЗП для " + i);
            for (int j = 0; j < selary[i].length; j++) {
                selary[i][j]= scanner.nextInt();
            }
        }

    }

    private static void getFamily(Scanner scanner,String[] family){

        for (int i = 0; i <family.length ; i++) {
            family[i] = scanner.next();
        }
    }


}
