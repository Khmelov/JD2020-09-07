package by.it.hryntsaliou.jd01_01;

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
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = a + b;
        System.out.println("DEC:" + a + "+" + b + "=" + c);
        String convertFirst = Integer.toBinaryString(a);
        String convertSecond = Integer.toBinaryString(b);
        String convertResult = Integer.toBinaryString(c);
        System.out.println("BIN:" + convertFirst + "+" + convertSecond + "=" + convertResult);
        String convertFirst1 = Integer.toHexString(a);
        String convertSecond1 = Integer.toHexString(b);
        String convertResult1 = Integer.toHexString(c);
        System.out.println("HEX:" + convertFirst1 + "+" + convertSecond1 + "=" + convertResult1);
        String convertFirst2 = Integer.toOctalString(a);
        String convertSecond2 = Integer.toOctalString(b);
        String convertResult2 = Integer.toOctalString(c);
        System.out.println("OCT:" + convertFirst2 + "+" + convertSecond2 + "=" + convertResult2);
    }
}
