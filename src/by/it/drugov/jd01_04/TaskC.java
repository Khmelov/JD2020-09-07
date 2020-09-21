package by.it.drugov.jd01_04;

import java.util.Scanner;

 class TaskC {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.next();
        buildOneDimArray(line);
    }

    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        InOut.printArray(array, "V", 5);
        double firstElement = array[0];
        double lastElement = array[array.length - 1];
        Helper.sort(array);
        // MergeSort(array, 0, array.length - 1);
        InOut.printArray(array, "V", 4);
        int indexFirst = binarySearch(array, firstElement);
        System.out.printf("first element=%d \n",indexFirst);
        int indexLast = binarySearch(array,lastElement);
        System.out.printf("last element=%d",indexLast);
    }

    static int binarySearch(double[] array, double value) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (array[middle] == value) {
                return middle;
            } else if (array[middle] > value) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }

    static void MergeSort(double[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            //    Merge(MergeSort(array,left,middle),MergeSort(array,middle+1,right));
        }
    }

    // static int Merge(double[] array, int va) {
    //  }

}
