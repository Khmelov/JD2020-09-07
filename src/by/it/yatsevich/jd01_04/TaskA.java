package by.it.yatsevich.jd01_04;

import java.util.Scanner;

class TaskA {
    static void printMulTable() {
        for (int i = 2; i <= 9; i++) {
            for (int j = 2; j < 10; j++) {
                System.out.printf("%1d*%1d=%-3d", i, j, i * j);
            }
            System.out.println();}
    }

    static void buildOneDimArray(String line){
        double[] arr = InOut.getArray(line);
        InOut.printArray(arr,"V",5);
        double frst=arr[0];
        double lst=arr[arr.length-1];
        Helper.sort(arr);
        InOut.printArray(arr,"V",4);
        for (int i = 0; i <= arr.length-1 ; i++) {
            if (arr[i]==frst) System.out.println("Index of first element="+i);
            if  (arr[i]==lst) System.out.println("Index of last element="+i);
        }

    }

    public static void main(String[] args) {
        printMulTable();
        Scanner scanner = new Scanner(System.in);
        String smth = scanner.nextLine();
        buildOneDimArray(smth);
    }
}
