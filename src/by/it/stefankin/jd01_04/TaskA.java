package by.it.stefankin.jd01_04;

import java.util.Scanner;

public class TaskA {

    public static void main(String[] args) {
        printMulTable();

        Scanner sc=new Scanner(System.in);
        String vvod =sc.nextLine();
        buildOneDimArray(vvod);

    }

    static void printMulTable() {
        for (int i=2;i<=9;i++) {
            for (int j = 2; j < 10; j++) {
                System.out.printf("%1d*%1d=%-2d ",i,j,i*j);
                }
            System.out.println();
        }
    }

    static void buildOneDimArray(String line) {
        double[] mas =InOut.getArray(line);
        double start=mas[0];
        double stop=mas[mas.length-1];
        InOut.printArray(mas,"V",5);
        Helper.sort(mas);
        InOut.printArray(mas,"V",4);
        for (int i = 0; i < mas.length; i++) {
           if (mas[i]==start) {
               System.out.println("Index of first element = "+i);
               break;
           }
        }
        for (int i = 0; i < mas.length; i++) {
            if (mas[i]==stop) {
                System.out.println("Index of last element = "+i);
                break;
            }
        }


        }



}
