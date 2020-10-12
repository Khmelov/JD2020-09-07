package by.it._tasks_.jd01_01;

import java.util.Scanner;

/* Нужно написать программу, которая вводит два числа с клавиатуры
и 4 раза выводит их сумму с обозначением системы счисления на экран в
ДЕСЯТИЧНОМ ДВОИЧНОМ ШЕСТНАДЦАТИРИЧНОМ ВОСЬМИРИЧНОМ виде

Вот пример ввода с клавиатуры:
34 26

Тогда вывод ожидается такой (обратите внимание на регистр букв):
DEC:34+26=60
BIN:100010+11010=111100
HEX:22+1a=3c
OCT:42+32=74
*/
class TaskC2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите первое число:");
        int i = sc.nextInt();
        System.out.println("Введите второе число:");
        int j = sc.nextInt();
        System.out.println("Вывод");
        int sumDEC = i + j;
        System.out.println("DEC:" + i + "+" + j + "=" + sumDEC);
        System.out.println("BIN:" + Integer.toBinaryString(i) + "+" + Integer.toBinaryString(j) + "=" + Integer.toBinaryString(sumDEC));
        System.out.println("HEX:" + Integer.toHexString(i) + "+" + Integer.toHexString(j) + "=" + Integer.toHexString(sumDEC));
        System.out.println("OCT:" + Integer.toOctalString(i) + "+" + Integer.toOctalString(j) + "=" + Integer.toOctalString(sumDEC));
    }
}
