package by.it.akhmelev.jd01_03;

import java.util.Arrays;
import java.util.Scanner;

class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        double[] array = InOut.getArray(line);
        InOut.printArray(array);
        InOut.printArray(array,"V",4);
        Arrays.sort(array);
        InOut.printArray(array,"V",3);
    }
}
