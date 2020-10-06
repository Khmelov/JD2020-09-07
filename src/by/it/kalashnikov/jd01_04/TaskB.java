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
//            for (int i = 0; i < salary.length; i++) {
//                System.out.println();
//                System.out.print("Введите зарплату для " + fam[i]+"\n");
//                int res=0;
//                for (int j = 0; j < salary[i].length; j++) {
//                    salary[i][j] = sc.nextInt();
//                    res=salary[i][j]+res;
//                    System.out.printf("%-5d", salary[i][j]);
//                }
//        }
        System.out.printf("%-10s%-10s%-10s%-10s%-10s%-10s%n",
                "Фамилия",
                "Квартал 1",
                "Квартал 2",
                "Квартал 3",
                "Квартал 4",
                "Итого");
        int salaryIt = 0;
        for (int i = 0; i < salary.length; i++) {
            System.out.printf("%8s: ", fam[i]);
            int allName = 0;
            for (int j = 0; j < salary[i].length; j++) {
                salary[i][j] = sc.nextInt();
                System.out.printf("%-9d ", salary[i][j]);
                allName = allName + salary[i][j];
            }
            System.out.printf("%-10d", allName);
            System.out.println();
            salaryIt = salaryIt + allName;
        }
        System.out.printf("Итого   %-5d", salaryIt);
        System.out.println();
        double avgSalary =  (salaryIt/(n*4.0));
        System.out.printf("Средняя %-10.6f", avgSalary);
        System.out.println();


    }

}
