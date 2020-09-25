package by.it.adryneuski.jd01_03;

import java.util.Scanner;

import static by.it.adryneuski.jd01_03.Helper.findMax;
import static by.it.adryneuski.jd01_03.Helper.findMin;
import static by.it.adryneuski.jd01_03.InOut.printMatrix;
import static by.it.adryneuski.jd01_03.InOut.printVector;

public class Runner {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine();

//        double[] array = InOut.getArray(str);
//        InOut.printArray(array);
//        InOut.printArray(array,"V",3);
//        System.out.println(findMin(array));
//        System.out.println(findMax(array));
        printMatrix(4);
        System.out.println();
        printVector(4);

        }
    }

