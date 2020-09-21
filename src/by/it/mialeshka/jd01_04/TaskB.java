package by.it.mialeshka.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] lastname = new String[n];
        int in = 0;
        do
        {
            lastname[in] = scanner.next();
            in++;
        } while (in < n);

        scanner.nextLine();
        int[][] salary = new int[n][4];
        for (int i = 0; i < n; i++) {
            System.out.println("Введите зарплату для " + lastname[i]);
            String stringValue= scanner.nextLine();
            String[] stringArr = stringValue.split(" ");
            for (int j = 0; j < stringArr.length; j++) {
                salary[i][j] = Integer.parseInt(stringArr[j]);
            }
        }
       System.out.println("----------------------------------------------------");
       System.out.println("Фамилия   Квартал1 Квартоал2 Квартал3 Квартал4 Итого");
       System.out.println("----------------------------------------------------");
       int total = 0;
        for (int i = 0; i < n; i++) {
            System.out.printf("%8s: ", lastname[i]);
            int totalName = 0;
            for (int j = 0; j < salary[0].length; j++) {
                System.out.printf("%-8d ", salary[i][j]);
                totalName = totalName + salary[i][j];
            }
            System.out.printf("%-5d", totalName);
            System.out.println();
            total = total+ totalName;
        }
       System.out.println("----------------------------------------------------");
       System.out.printf("Итого   %-5d", total);
       System.out.println();
       double midSalary =  (total/(n*4.0));
       System.out.printf("Средняя %-10.6f", midSalary);
       System.out.println();
    }
}
