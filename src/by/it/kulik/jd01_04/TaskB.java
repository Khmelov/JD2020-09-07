package by.it.kulik.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // Объявляем Scanner
        System.out.println("Число рабочих: ");
        int amount = s.nextInt(); // Читаем с клавиатуры размер массива и записываем в amount
        String array[] = new String[amount]; // Создаём массив int размером в amount
        System.out.println("Фамилии рабочих:");
        /*Пройдёмся по всему массиву, заполняя его*/
        for (int i = 0; i < amount; i++) {
            Scanner scanner = new Scanner(System.in);
            array[i] = scanner.nextLine(); // Заполняем массив фамилиями, введёнными с клавиатуры
        }
        String array2[][] = new String[amount][4]; // Создаём массив array2 строк=amount, столбцов=4
        for (int i = 0; i < amount; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.println("Зарплата:");
                Scanner zarplata = new Scanner(System.in);
                array2[i][j] = zarplata.nextLine(); // Выводим на экран, полученный массив
            }


        }
        System.out.println();
    }
}
