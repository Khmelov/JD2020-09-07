package by.it.yatsevich.jd01_01;
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
        Scanner sc1 = new Scanner(System.in);
        int a = sc1.nextInt();
        int b = sc1.nextInt();
        int c = a+b;
            System.out.println("DEC:" +a+"+"+b + "=" + c);
        String a1 = Integer.toBinaryString(a);
        String b1 = Integer.toBinaryString(b);
        String c1 = Integer.toBinaryString(c);
            System.out.println("BIN:" +a1+"+"+b1 + "=" + c1);
        String a2 = Integer.toHexString(a);
        String b2 = Integer.toHexString(b);
        String c2 = Integer.toHexString(c);
            System.out.println("HEX:" +a2+"+"+b2 + "=" + c2);
        String a3 = Integer.toOctalString(a);
        String b3 = Integer.toOctalString(b);
        String c3 = Integer.toOctalString(c);
            System.out.println("OCT:" +a3+"+"+b3 + "=" + c3);
    }


}
