package by.it.mialeshka.jd01_04;

import java.util.Scanner;

public class TaskC {

    public static void main(String[ ] args){
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        buildOneDimArray(line);
    }

    static void mergeSort(double[ ] array){
        double[] arrayRes = mergeSortR(array);

        for (int i = 0; i < array.length; i++) {
            array[i] = arrayRes[i];
        }
    }

    static double[] mergeSortR(double[ ] array){
        if(array.length < 2) return array;

        int m = array.length/2;
        double[] part1 = new double[m];
        double[] part2  = new double[array.length-m];
        for (int i = 0; i < m; i++) {
            part1[i] = array[i];
        }
        int ip2 = 0;
        for (int i = m; i < array.length; i++) {
            part2[ip2] = array[i];
            ip2++;
        }
        part1 = mergeSortR(part1);
        part2 = mergeSortR(part2);
        return merge(part1, part2);
    }

    private static double[ ] merge(double[ ] part1, double[ ] part2)
    {
        double[] res = new double[part1.length + part2.length];
        int indexp1 = 0;
        int indexp2 = 0;
        int indexres = 0;
        do {

             if (indexp1 < part1.length && indexp2 < part2.length && part1[indexp1] < part2[indexp2]) {
                 res[indexres] = part1[indexp1];
                 indexres++;
                 indexp1++;
             }
             else{
                 if (indexp1 < part1.length && indexp2 < part2.length && part2[indexp2] < part1[indexp1] ) {
                     res[indexres] = part2[indexp2];
                     indexres++;
                     indexp2++;
                 }
                 else {
                     if (indexp2 < part2.length && indexp1 < part1.length && part2[indexp2] == part1[indexp1]) {
                         res[indexres] = part2[indexp2];
                         indexres++;
                         res[indexres] = part1[indexp1];
                         indexres++;
                         indexp2++;
                         indexp1++;
                     }
                     else{
                         if (indexp1 < part1.length && indexp2 >= part2.length) {
                             res[indexres] = part1[indexp1];
                             indexres++;
                             indexp1++;
                         }
                         else{
                             if (indexp2 < part2.length && indexp1 >= part1.length) {
                                 res[indexres] = part2[indexp2];
                                 indexres++;
                                 indexp2++;
                             }
                         }
                     }
                 }
             }
        } while (indexp1 < part1.length || indexp2 < part2.length);
        return res;
    }

    static int binarySearch(double[ ] array, double value){
        int l = array.length;
        int f = 0;
        int mid = array.length-1;

        if(array.length > 1) {
            do
            {
                mid = f+(l-f)/2;
                if (value < array[mid]) {
                    l = mid - 1;
                }
                else {
                    if(value > array[mid])
                    {
                        f = mid + 1;
                    }
                }
            } while (array[mid] != value);
        }
        return mid;
    }

    static void buildOneDimArray(String line){
        double[] res = InOut.getArray(line);
        InOut.printArray(res, "V",  5);
        double firstElement = res[0];
        double lastElement = res[res.length-1];
        mergeSort(res);
        InOut.printArray(res, "V", 4);
        int indexFirstElement = binarySearch(res, firstElement);
        int indexLastElement = binarySearch(res, lastElement);

        System.out.println("Index of first element=" + indexFirstElement);
        System.out.println("Index of last element=" + indexLastElement);
    }
}
