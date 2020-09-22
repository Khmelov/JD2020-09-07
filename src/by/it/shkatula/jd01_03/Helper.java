package by.it.shkatula.jd01_03;

import java.util.Arrays;

public class Helper {

    static double findMin(double[] arr) {
        double minValue = arr[0];
        for (double v : arr) {
            if (minValue > v) minValue = v;
        }
        return minValue;
    }

    static double findMax(double[] arr) {
        double maxValue = arr[0];
        for (double v : arr) {
            if (maxValue < v) maxValue = v;
        }
        return maxValue;
    }

    static void sort(double[] arr) {
        boolean swap;
        do {
            swap = false;
            for (int i = 0; i < arr.length-1; i++)
                if (arr[i] > arr[i + 1]) {
                    double tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                    swap = true;
                }
        }
        while (swap);
        System.out.println(Arrays.toString(arr));
    }
}
