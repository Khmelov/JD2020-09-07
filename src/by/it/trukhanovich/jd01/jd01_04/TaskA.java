package by.it.trukhanovich.jd01.jd01_04;

import java.util.Scanner;

public class TaskA {
    public static void main(String[ ] args){
        printMulTable();
        Scanner scanner=new Scanner(System.in);
        String s = scanner.nextLine();
        buildOneDimArray(s);
    }
    static void buildOneDimArray(String line){
        double[] array = InOut.getArray(line);
        double firstArray= array[0];
        double lastArray= array[array.length-1];
        InOut.printArray(array, "V",5);
        Helper.sort(array);
        InOut.printArray(array, "V",4);
        int firstIndex = 0;
        int lastIndex=0;
        for (int i = 0; i < array.length; i++) {
            if (array[i]==firstArray) firstIndex=i;
            if (array[i]==lastArray) lastIndex=i;
        }
        System.out.printf("Index of first element=%d" +"\n" +
                "Index of last element=%d", firstIndex, lastIndex);
    }
    static void printMulTable(){
        for (int i = 2; i <=9 ; i++) {
            for (int j = 2; j <=9; j++) {
                System.out.printf("%d*%d=%-3d", i, j, i*j);
            }
            System.out.println();
        }
    }
}
