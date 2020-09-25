package by.it.stefankin.jd01_01;

import java.util.Scanner;

/* Нужно написать программу, которая вводит два числа с клавиатуры
и выводит их сумму на экран в виде

Ввод (это вы вводите с клавиатуры):
34 26

Вывод (это должна появится в консоли, обратите внимание на пробелы и слово Sum:
Sum = 60

*/
class TaskC1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int vvod1 = sc.nextInt();
        int vvod2 = sc.nextInt();
        int sum = vvod1+vvod2;
        System.out.println("Ввод:");
        System.out.println(vvod1+" "+vvod2);
        System.out.println("Вывод:");
        System.out.println("Sum = "+sum);

    }




}
