package by.it.drugov.jd01_03;

import java.util.Scanner;

 class InOut {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        double[] array = getArray(line);
        printArray(array);
        String name = scanner.next();
        int columnCount = scanner.nextInt();
        printArray(array, name , columnCount);
        Helper.findMin(array);
    }

     /**
      * printArray выводит массив на экран
      *
      * @param array одномерный массив чисел типа double
      * @param name название массива типа String
      * @param columnCount количество колонок, в которые будет выведен массив
      */
     static void printArray(double[] array, String name, int columnCount) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf(" %s [ %-2d] = %-4.1f", name, i, array[i]);
            if (((i+1) % columnCount == 0) || (i == array.length -1)) {
                System.out.println();
            }
        }
    }

     /**
      * printArray выводит одномерный массив на экран
      *
      * @param array одномерный массив чисел типа double
      */
    private static void printArray(double[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

     /**
      * getArray преобразует полученную строку в массив чисел
      *
      * @param line строка, используемая для преобразования в массив чисел
      * @return arrayNumbers возвращает одномерный массив чисел типа double
      */
    static double[] getArray(String line) {
        String[] arrayString = new String[line.length()];
        arrayString = (line.trim().split(" "));
        double[] arrayNumbers = new double[arrayString.length];
        for (int i = 0; i < arrayString.length; i++) {
            arrayNumbers[i] = Double.parseDouble(arrayString[i]);
        }
        return arrayNumbers;
    }
}
