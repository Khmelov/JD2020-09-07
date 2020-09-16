package by.it.shkatula.jd01_04;

import java.util.Scanner;

// Ваня Коля Петя
public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        String[] empl = new String[n];
        for (int i = 0; i < empl.length; i++) {
            empl[i] = scanner.next();
            System.out.println(empl[i]);
        }
        int[][] salary = new int[n][4];
        for (int i = 0; i < empl.length; i++) {
            System.out.println("Введите зарплату для " + empl[i]);
            for (int j = 0; j < 4; j++) {
                salary[i][j] = scanner.nextInt();

            }

        }
        int sum = 0;
        for (int i = 0; i < empl.length; i++) {
            for (int j = 0; j < 4; j++) {
                sum += salary[i][j];
            }
        }
        float amount = 0;
        for (int i = 0; i < empl.length; i++) {
            for (int j = 0; j < 4; j++) {
                amount += 1;
            }
        }
        float avr = sum / amount;
        System.out.printf("%8s  %-12s%-12s%-12s%-12s%-8s%n", "Фамилия", "Квартал1", "Квартал1", "Квартал1", "Квартал1", "Итого");
        System.out.println("---------------------------------------------------------------");
        for (int i = 0; i < n; i++) {
            System.out.printf("%8s  %-12d%-12d%-12d%-12d%-8d%n", empl[i], salary[i][0], salary[i][1], salary[i][2], salary[i][3], salary[i][0] + salary[i][1] + salary[i][2] + salary[i][3]);
            System.out.println("---------------------------------------------------------------");
            System.out.printf("%8s  %-12d%n", "Итого", sum);
            System.out.printf("%8s  %-7.3f%n", "Средняя", avr);
        }
    }
}
