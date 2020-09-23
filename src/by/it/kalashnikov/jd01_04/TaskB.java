package by.it.kalashnikov.jd01_04;

import java.util.Scanner;

 class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String [] fam= new String [n];
        for (int i = 0; i < fam.length ; i++) {
            fam[i]= sc.next();
        }

        int [][] salary= new int [n][4];

            for (int i = 0; i < salary[i].length; i++) {
                System.out.print("Введите зарплату для " + fam[i]);
                for (int j = 0; j < salary[i].length; j++) {

                    salary[i][j] = sc.nextInt();
                    System.out.println();
                    System.out.println(salary[i][j]);
                }

        }

    }

}
