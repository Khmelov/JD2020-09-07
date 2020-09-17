package by.it.kulik.jd01_01;


import java.math.BigDecimal;
import java.math.RoundingMode;
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
1. Метод getWeight(int weightо переводить вес тела в килограммах на Земле
    в вес этого же тела на Марсе, и воз) должен быть статическим.
2. Метод getWeight должен возвращать значение типа double.
3. Метод getWeight должен обязательно (!) округлять до сотых возвращаемое значение типа double.
4. Метод getWeight не должен ничего выводить на экран.
5. Метод getWeight должен правильнвращать это значение.

Пример:

Ввод:
75

Вывод:
29.51


*/
class TaskC3 {


    public static void main(String[] args) {
        int a;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите:");
         a = sc.nextInt();

        System.out.println(getWeight(a));}


    public static double getWeight(int earthWeight) {
        double moonWeight = earthWeight*3.86/9.81;
        BigDecimal bd = new BigDecimal(earthWeight).setScale(2, RoundingMode.HALF_UP);
        earthWeight = (int) bd.doubleValue();
        return moonWeight;
    }
}
