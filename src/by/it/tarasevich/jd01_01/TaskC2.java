package by.it.tarasevich.jd01_01;

import java.util.Scanner;

import static java.lang.Integer.*;

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
        int sum = a+b;

         {
            System.out.println("DEC" + ":" + Integer.toString(a) + "+" + Integer.toString(b) + "=" +Integer.toString(sum));
        }
        {
            System.out.println("BIN" + ":" + toBinaryString(a) + "+" + toBinaryString(b) + "=" + toBinaryString(sum));
        }
        {
            System.out.println("HEX" + ":" + toHexString(a) + "+" + toHexString(b) + "=" + toHexString(sum));
        }
        {
            System.out.println("OCT" + ":" + toOctalString(a) + "+" + toOctalString(b) + "=" + toOctalString(sum));
        }
    }

}
