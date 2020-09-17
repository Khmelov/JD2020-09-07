package by.it.adryneuski.jd01_01;

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
    public static void main(String[] args){

        Scanner sc1 = new Scanner(System.in);
         System.out.println("Введите первое слагаемое:");
          int i=sc1.nextInt();

          Scanner sc2 = new Scanner(System.in);
           System.out.println("Введите второе слагаемое:");
            int j=sc2.nextInt();

        int k = i+j;

        System.out.println("DEC:" + i + "+"+ j + "=" + k);
        //System.out.println("BIN:" + i + "+"+ j + "=" + k);
        System.out.printf("HEX:" + "i=%x; j=%x \n", i, j + "=" + k);
       // System.out.println("DEC:" + i + "+"+ j + "=" + k);

        //System.out.printf("i=%x; j=%x \n", i, j);
    }


}
