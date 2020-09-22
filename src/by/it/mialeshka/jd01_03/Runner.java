package by.it.mialeshka.jd01_03;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String strLine = scanner.nextLine();
        double[] arr = InOut.getArray(strLine);
        InOut.printArray(arr);
        InOut.printArray(arr, "V", 3);

        double MinValue = Helper.findMin(arr);
        double MaxValue = Helper.findMax(arr);
        Helper.sort(arr);

        double[][] arrC3 = {{1,2,3},
                            {4,5,6},
                            {4,5,6},
        };
        double[] vectorC3 = {4,5,6};

        double[] resC3 = Helper.mul(arrC3, vectorC3);

        double[][] res2C3 = Helper.mul(arrC3, arrC3);


    }
}
