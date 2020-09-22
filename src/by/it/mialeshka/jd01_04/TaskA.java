package by.it.mialeshka.jd01_04;

import java.util.Scanner;

public class TaskA {

    public static void main(String[ ] args){
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        printMulTable();
        buildOneDimArray(line);
    }

    static void printMulTable(){
        for (int i = 2; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                System.out.printf("%1d*%1d=%-2d ", i, j, i*j);
            }
            System.out.println();
        }
        System.out.println();
    }

    static void sort(double[ ] arr) {
        for (int i = arr.length - 1; i >= 1; i--){
            for (int j = 0; j < i; j ++){
                if(arr[j] > arr[j + 1]){
                    double larger = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = larger;
                }
            }
        }
    }

    static void buildOneDimArray(String line){
        double[] res = InOut.getArray(line);
        InOut.printArray(res, "V", 5);
        double firstElement = res[0];
        double lastElement = res[res.length-1];
        sort(res);
        InOut.printArray(res, "V", 4);
        int indexFirstElement = -1;
        int indexLastElement = -1;

        for (int i = 0; i < res.length; i++) {
            if(res[i] == firstElement) indexFirstElement = i;
            if(res[i] == lastElement) indexLastElement = i;

            if(indexFirstElement > -1 && lastElement > -1) break;
        }

        System.out.println("Index of first element=" + indexFirstElement);
        System.out.println("Index of last element=" + indexLastElement);
      }
}
