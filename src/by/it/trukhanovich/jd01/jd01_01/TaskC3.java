package by.it.trukhanovich.jd01.jd01_01;

import java.util.Scanner;

/*
Ускорение свободного падения на Земле и Марсе таково:
Марс   3.86
Земля   9.81

С клавиатуры вводится вес человека в килограммах.
Рассчитайте вес человека на Марсе и выведите
округлив его до сотых килограмма (2 знака)

Создайте для этих целей метод getWeight(int weight)

Требования:
1. Метод getWeight(int weight) должен быть статическим.
2. Метод getWeight должен возвращать значение типа double.
3. Метод getWeight должен обязательно (!) округлять до сотых возвращаемое значение типа double.
4. Метод getWeight не должен ничего выводить на экран.
5. Метод getWeight должен правильно переводить вес тела в килограммах на Земле
    в вес этого же тела на Марсе, и возвращать это значение.

Пример:

Ввод:
75

Вывод:
29.51


*/
class TaskC3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int weight= sc.nextInt();
        double a= getWeight (weight);
        System.out.println(a);
    }

    public static double getWeight(int weight ) {
     //   Scanner sc = new Scanner(System.in);
     //   int x= sc.nextInt();
        double i=9.81;
        double j=3.86;
        double k=(weight*j)/i;
//        double k1= (k*100);
//        double k2= java.lang.Math.round (k1);
//        double b= (double) k2/100;
//        double b= (double) k2/100;
//        return b;
//        округление возможно без round
        double k100= (k*100);
        double delta= k100-(int)k100;
        if (delta<0.5) return ((int)k100/100.0);
        return ((int)k100+1)/100.0;
    }
}
