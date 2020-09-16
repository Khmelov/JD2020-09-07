package by.it.drugov.jd01_04;

import java.util.Scanner;

 class TaskA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printMulTable();
        String line = scanner.nextLine();
        buildOneDimArray(line);
    }

    static void printMulTable() {
        for (int i = 2; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                System.out.printf("%d*%d=%-3d", i, j, i * j);
            }
            System.out.println();
        }
    }

    static void findIndex(double[] array, double firstElement, double lastElement) {
        int indexFirst = 0;
        int indexLast = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == firstElement) {
                indexFirst = i;
            }
            if (array[i] == lastElement) {
                indexLast = i;
            }
        }
        System.out.printf("Index of first element=%1d \n", indexFirst);
        System.out.printf("Index of last element=%1d", indexLast);
    }

    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        InOut.printArray(array, "V", 5);
        double firstElement = array[0];
        double lastElement = array[array.length - 1];
        Helper.sort(array);
        InOut.printArray(array, "V", 4);
        findIndex(array, firstElement, lastElement);
    }
}
