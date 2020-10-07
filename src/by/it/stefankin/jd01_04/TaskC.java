package by.it.stefankin.jd01_04;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String vvod =sc.nextLine();
        buildOneDimArray(vvod);

    }


    static void buildOneDimArray(String line) {
        double[] mas =InOut.getArray(line);
        double start=mas[0];
        double stop=mas[mas.length-1];
        InOut.printArray(mas,"V",5);

        mergeSort(mas);
        binarySearch(mas,start);
        binarySearch(mas,stop);
        InOut.printArray(mas,"V",4);



    }
     static void mergeSort(double[ ] array){
        int n = array.length;
        if (n<2) {
            return;
        }
         int mid = n / 2;
         double[] left = new double[mid];
         double[] right = new double[n - mid];

         for (int i = 0; i < mid; i++) {
             left[i] = array[i];
         }
         for (int i = mid; i < n; i++) {
             right[i - mid] = array[i];
         }
         mergeSort(left, mid);
         mergeSort(right, n - mid);

         merge(array,left, right);

         }



    private static void mergeSort(double[ ] array, int num){
        int n = num;
        if (n<2) {
            return;
        }
        int mid = n / 2;
        double[] left = new double[mid];
        double[] right = new double[n - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = array[i];
        }
        for (int i = mid; i < n; i++) {
            right[i - mid] = array[i];
        }
        mergeSort(left, mid);
        mergeSort(right, n - mid);
       // System.out.println("+++");
        merge(array,left, right);
    }

    private static void merge(double[] arr,double[ ] part1, double[ ] part2) {

        int l =part1.length;
        int r =part2.length;
        int sal=l+r;

        int i = 0, j = 0, k = 0;
        while (i < l && j < r) {
            if (part1[i] <= part2[j]) {
                arr[k++] = part1[i++];
            }
            else {
                arr[k++] = part2[j++];
            }
        }
        while (i < l) {
            arr[k++] = part1[i++];
        }
        while (j < r) {
            arr[k++] = part2[j++];
        }
        //System.out.println("+-+-+");
    }
    static int binarySearch(double[ ] array, double value) {

        int m=array.length/2;
        int ind=m;
        boolean searh=true;
        while (searh)
        if (array[m]==value) {
            ind = m;
            searh =false;
        } else
            if (array[m]<value ) {
            m=m+(array.length-m)/2;

        } else
            if (array[m]>value) {
            m=m-(array.length-m)/2;

        }
        System.out.println("индекс :"+ ind);
        return ind;
    }

}
