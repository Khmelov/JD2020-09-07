package by.it.stefankin.jd01_01;

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
        Scanner sc=new Scanner(System.in);
        int vvod1 = sc.nextInt();
        int vvod2 = sc.nextInt();
        int sum = vvod1+vvod2;

        System.out.println("DEC:"+vvod1+"+"+vvod2+"="+sum);
        System.out.println("BIN:"+Integer.toBinaryString(vvod1)+"+"+Integer.toBinaryString(vvod2)+"="+Integer.toBinaryString(sum));
        System.out.println("HEX:"+Integer.toHexString(vvod1)+"+"+Integer.toHexString(vvod2)+"="+Integer.toHexString(sum));
        System.out.println("OCT:"+Integer.toOctalString(vvod1)+"+"+Integer.toOctalString(vvod2)+"="+Integer.toOctalString(sum));

    }


}
