package by.it.kulik.jd01_01;


import java.text.DecimalFormat;
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
        int earthWeight;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите вес на земле:");
        earthWeight = sc.nextInt();
        double marsWeight = getWeight(earthWeight);
        double marsWeight100 = (double) Math.round(marsWeight*100)/100;
        System.out.println(marsWeight100);
    }

    private static double getWeight(int earthWeight) {
double marsWeight= earthWeight*3.86/9.81;

return marsWeight;
    }

}
