package by.it.akhmelev.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskA {

    public static void main(String[] args) {
        printMulTable();
        Scanner sc=new Scanner(System.in);
        String line = sc.nextLine();
        buildOneDimArray(line);
    }


    static void printMulTable(){
        for (int i = 2; i <= 9; i++) {
            for (int j = 2; j < 10; j++) {
                System.out.printf("%1d*%1d=%-3d",i,j,i*j);
            }
            System.out.println();
        }
    }

    static void buildOneDimArray(String line){
        double[] array = InOut.getArray(line);
        InOut.printArray(array,"V",5);
        double first = array[0];
        double last = array[array.length - 1];
        Helper.sort(array);
        InOut.printArray(array,"V",4);
        int indexFirst = -1;
        int indexLast = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i]==first) {
                indexFirst=i;
            }
            if (array[i]==last) {
                indexLast=i;
            }
        }

        System.out.printf(
                "\t\tIndex of first element=%d\n" +
                "\t\tIndex of last element=%d\n"
        ,indexFirst,indexLast);
    }
}
