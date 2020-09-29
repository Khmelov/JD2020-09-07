package by.it.yatsevich.jd01_01;
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
        Scanner sc1 = new Scanner(System.in);
        int weight = sc1.nextInt();
        System.out.println(getWeight(weight));
    }
    public static double getWeight(int weight) {
        double a = weight*(3.86/9.81);
        double ostL;
        int b = (int) a;
        double ostO = (int) (a * 1000 - b * 1000);
        double j = (int) (ostO/10);
        double ostT=(int)(ostO - j*10);
        if (ostT>=5) {
            ostL= j + 1;
        } else {
            ostL= j;
        }
        double c1;
        c1 = ((b * 100) + ostL) / 100;
        return c1;
    }
}
