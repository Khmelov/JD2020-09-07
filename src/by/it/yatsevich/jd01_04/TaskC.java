package by.it.yatsevich.jd01_04;

import java.util.Arrays;

public class TaskC {

    static void buildOneDimArray(String line) {
        //double val = arr[i];
        double[] arr = InOut.getArray(line);
        InOut.printArray(arr, "V", 5);
        double frst = arr[0];
        double lst = arr[arr.length - 1];
        mergeSort(arr);
        InOut.printArray(arr, "V", 4);
        for (int i = 0; i <= arr.length - 1; i++) {
            if (arr[i] == frst) System.out.println("Index of first element=" + i);
            if (arr[i] == lst) System.out.println("Index of last element=" + i);
        }
    }


    static void mergeSort(double[] array) {
        double[] result = mergeSort(array, 0, array.length);
        System.out.println(Arrays.toString(result));
    }

    private static double[] mergeSort(double[] array, int left, int right) {
        double[] buffer1 = Arrays.copyOf(array, array.length);
        double[] buffer2 = new double[array.length];
        if (left >= right - 1) {
            return buffer1;
        }
        int middle = left + (right - left) / 2;
        double[] sorted1 = mergeSort(buffer1,left, middle);
        double[] sorted2 = mergeSort(buffer1,middle, right);
        double[] result =  merge(buffer1, buffer2, left, right, middle, sorted1, sorted2);
        return result;
    }

    private static double[] merge(double[] buffer1, double[] buffer2, int startIndex, int endIndex, int middle, double[] sorted1, double[] sorted2) {
        int index1 = startIndex;
        int index2 = middle;
        int destIndex = startIndex;
        double[] result = sorted1 == buffer1 ? buffer2 : buffer1;
        while (index1 < middle && index2 < endIndex) {
            result[destIndex++] = sorted1[index1] < sorted2[index2]
                    ? sorted1[index1++] : sorted2[index2++];
        }
        while (index1 < middle) {
            result[destIndex++] = sorted1[index1++];
        }
        while (index2 < endIndex) {
            result[destIndex++] = sorted2[index2++];
        }
        return result;
    }


    public static void main(String[] args) {
        double[] act = new double[15];
        for (int i = 0; i < act.length; i++) {
            act[i] = Math.random() * 31 - 15;

        }
        System.out.println(Arrays.toString(act));
        mergeSort(act);
        //System.out.println();
    }
}

