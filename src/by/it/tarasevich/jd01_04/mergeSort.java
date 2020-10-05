package by.it.tarasevich.jd01_04;

public class mergeSort {

    public static void main(String[] args) {

        double[] array = new double[7];
        for (int i = 0; i < array.length; i++) {
            array[i] = Math.random() * 31 - 15;
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();

        int left = 0;
        int right = array.length;
        int middle = 0;
        if (array.length < 2) {
            return;
        }

        if (left < right) {
            middle = (left + right) / 2;
        }
        double[] part1 = new double[middle];
        double[] part2 = new double[right - middle];
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
        System.out.println("array111");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }

    }
    private static void mergeSort(double[ ] array, int left, int right){
    if (array.length < 2) {
        return;
    }
    int middle=0;

            if (left < right) {
        middle = (left + right) / 2;
    }
    double[] part1 = new double[middle];
    double[] part2 = new double[right - middle];

            for (int a = 0; a < middle; a++) {
        part1[a] = array[a];
    }

            for ( int b = middle; b < right; b++) {
        part2 [b - middle] = array[b];
    }
    mergeSort(part1, left, middle);
    mergeSort(part2, middle+1, right);
    array = merge(part1, part2);
}
    private static void mergeSort(double[ ] array){
        int left = 0;
        int right = array.length;
        int middle = 0;
        if (array.length < 2) {
            return;
        }

        if (left < right) {
            middle = (left + right) / 2;
        }
        double[] part1 = new double[middle];
        double[] part2 = new double[right - middle];
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
