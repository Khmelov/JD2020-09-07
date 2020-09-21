package by.it.stefankin.jd01_03;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        trgetArray();
        trsortArray();
    }

    public static void trgetArray () {
       Scanner sc=new Scanner(System.in);
       String strline= sc.nextLine();
       InOut.printArray(InOut.getArray(strline));
       InOut.printArray(InOut.getArray(strline),"Tr",4);
       Helper.findMax(InOut.getArray(strline));
       Helper.findMin(InOut.getArray(strline));


    }

    public static void trsortArray() {
        Scanner sc=new Scanner(System.in);
        String strline= sc.nextLine();
        double[] a=InOut.getArray(strline);
        InOut.printArray(a);
        Helper.sort(a);
        InOut.printArray(a);

    }

}
