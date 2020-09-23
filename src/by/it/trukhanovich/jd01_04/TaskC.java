package by.it.trukhanovich.jd01_04;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        String s = scanner.nextLine();
        buildOneDimArray(s);
    }
    static void buildOneDimArray(String line){
        double[] array = InOut.getArray(line);
        double firstArray= array[0];
        double lastArray= array[array.length-1];
        InOut.printArray(array, "V",5);
        mergeSort(array);
        InOut.printArray(array, "V",4);
        int firstIndex = binarySearch (array, firstArray);
        int lastIndex= binarySearch (array, lastArray);
        System.out.printf("Index of first element=%d" +"\n" +
                "Index of last element=%d", firstIndex, lastIndex);
    }

    static int binarySearch(double[ ] array, double value) {
        int left=0;
        int right=array.length;
        int m=(left+right)/2;
        int res=-1;
        do {
            if (array[m] == value) {
                res = m;
            }
            if (array[m] > value) {
                right=m;
               m =  (left+right)/2;
            }
            if (array[m] < value) {
                left=m;
                m =  (left+right)/2;
            }
        }
        while (res==-1);
        return  res;
    }
    static void mergeSort(double[ ] array){
        int left = 0;
        int right = array.length;
        int middle = 0;
        if (array.length < 2) {return; }

        middle = (left + right) / 2;
        double[] part1 = new double[middle];
        double[] part2 = new double[right - middle];
// getArray
        for (int i = 0; i < middle; i++) {
            part1[i] = array[i];
        }

        for (int j = middle; j < right; j++) {
            part2[j - middle] = array[j];
        }
        mergeSort(part1);
        mergeSort(part2);
        double array1[]=new double[array.length];
        array1 = merge(part1, part2);
        for (int i = 0; i < array.length; i++) {
            array[i]=array1[i];
        }
        InOut.printArray(array);
        }

    private static double[] merge(double[] part1, double[] part2) {
        double[] array = new double[part1.length + part2.length];
        int i1 = 0;
        int i2 = 0;
        int i = 0;
        for (int i3 = 0; i3 < array.length; i3++) {
            if (i1==part1.length) {array[i3]=part2[i2]; i2++; continue;}
            else if (i2==part2.length) {array[i3]=part1[i1]; i1++; continue;}
            else if (part1[i1]<part2[i2]) {array[i3]=part1[i1]; i1++; continue;}
            else if (part1[i1]>part2[i2]) {array[i3]=part2[i2]; i2++; continue;}
        }
        return array;
    }

}
