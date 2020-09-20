package by.it.kulik.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите количество рабочих:");
        int amount = sc.nextInt();           // Читаем с клавиатуры размер массива и записываем в amount
        String[] mas = new String[amount];    //Создаем массив размером amount
        for (int i = 0; i < mas.length; i++) {
            System.out.println("Введите фамилию рабочего");
            Scanner scanner = new Scanner(System.in);
            mas[i] = scanner.nextLine();         //Заполняем массив фамилиями, введенными с клавиатуры
        }
        int[][] vedomost = new int[amount][4]; //Создаем массив размером строк amount и столбцов 4
        Scanner scan = new Scanner(System.in); //Объявляем сканнер
        for (int i = 0; i < amount; i++) {     //перебираем массив
            System.out.println("Введите зарплату рабочего" + mas[i]);
            for (int j = 0; j < vedomost[i].length; j++) {
                int zarplata = scan.nextInt(); //создан массив из зарплат работяг
                vedomost[i][j] = zarplata;
            }
            System.out.println(Arrays.deepToString(vedomost));
        }
        {
        }
    }
}
