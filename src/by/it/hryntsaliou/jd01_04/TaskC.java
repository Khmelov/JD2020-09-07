package by.it.hryntsaliou.jd01_04;

import java.util.Scanner;

class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        buildOneDimArray(line);
    }

    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        InOut.printArray(array, "V", 5);
        double first = array[0];
        double last = array[array.length - 1];
        //Helper.sort(array);
        mergeSort(array);
        InOut.printArray(array, "V", 4);
        int IndexFirst = binarySearch(array, first);
        System.out.printf("Index of first element=%d \n", IndexFirst);
        int IndexLast = binarySearch(array, last);
        System.out.printf("Index of last element=%d \n", IndexLast);
    }

    static int binarySearch(double[] array, double value) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int medium = (left + right) / 2;
            if (array[medium] == value) {
                return medium;
            } else if (array[medium] > value) {
                right = medium - 1;
            } else {
                left = medium + 1;
            }
        }
        return -1;
    }

    static void mergeSort(double[] array) {
        mergeSort1(array, 0, array.length - 1);
    }

    static void mergeSort1(double[] array, int left, int right) {
        if (left >= right) return;
        int medium = (left + right) / 2;
        mergeSort1(array, left, medium);
        mergeSort1(array, medium + 1, right);
        merge(array, left, medium, right);
    }

    static void merge(double[] array, int left, int medium, int right) {
        double[] leftArray = new double[medium - left + 1];
        double[] rightArray = new double[right - medium];
        for (int i = 0; i < leftArray.length; i++) {
            leftArray[i] = array[left + i];
        }
        for (int i = 0; i < rightArray.length; i++) {
            rightArray[i] = array[medium + i + 1];
        }
        int leftIndex = 0;
        int rightIndex = 0;
        for (int i = left; i < right + 1; i++) {
            if (leftIndex < leftArray.length && rightIndex < rightArray.length) {
                if (leftArray[leftIndex] < rightArray[rightIndex]) {
                    array[i] = leftArray[leftIndex];
                    leftIndex++;
                } else {
                    array[i] = rightArray[rightIndex];
                    rightIndex++;
                }
            } else if (leftIndex < leftArray.length) {
                array[i] = leftArray[leftIndex];
                leftIndex++;
            } else if (rightIndex < rightArray.length) {
                array[i] = rightArray[rightIndex];
                rightIndex++;
            }
        }
    }
}
