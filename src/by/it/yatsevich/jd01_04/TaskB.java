package by.it.yatsevich.jd01_04;

import java.util.Scanner;

class TaskB {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String [] familia=new String[n];
        for (int i = 0; i < familia.length; i++) {
            familia[i]=scanner.next(); }
        int N = familia.length;
        int [][] money = new int[N][4];
        for (int j = 0; j < money.length; j++) {
            System.out.println("Введите зарплату для "+familia[j]);
            int [] arrayLine = new int[4];
            for (int k = 0; k < arrayLine.length; k++) {
                arrayLine[k]=scanner.nextInt(); }
                for (int i = 0; i < money[j].length; i++)
                money[j][i] = arrayLine[i];
        }
            String elem="______________________________________________________";
            System.out.println(elem);
            System.out.printf("%-9s%-10s%-10s%-10s%-10s%-5s","Фамилия","Квартал1","Квартал2","Квартал3","Квартал4","Итого");
            System.out.println();
            System.out.print(elem);
            System.out.println();
                int summoneyit = 0;
                for (int k = 0; k < money.length; k++) {
                    int summoney=money[k][0]+money[k][1]+money[k][2]+money[k][3];
                    System.out.printf("%8s:%-10d%-10d%-10d%-10d%-5d",familia[k],money[k][0],money[k][1],money[k][2],money[k][3],summoney);
                    System.out.println();
                    summoneyit+=summoney;
                }
            System.out.println(elem);
            System.out.printf("%-9s%-10d","Итого",summoneyit);
            System.out.println();
            double sr = summoneyit;
            System.out.printf("%-9s%-9.6f","Средняя",(sr/12));
    }
}
