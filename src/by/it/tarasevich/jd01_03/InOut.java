package by.it.tarasevich.jd01_03;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InOut {
    public static String consoleReaderLine() throws IOException {

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader line = new BufferedReader(inputStreamReader);
        String out = line.readLine();

        return out;
    }

     static double[] getArray (String line) {
        String[] lineArray = line.split(" ");
        double[] res = new double[lineArray.length];
        for (int i = 0; i < lineArray.length; i++) {
            res[i] = Double.parseDouble(lineArray[i]);
        }
        return res;
    }
    static void printArray(double[ ] arr) {
        for (double element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    static void printArray(double[ ] arr, String name, int columnCount) {
        for (int i = 0; i <= arr.length; i++) {
            System.out.printf("%s[% -3d]=%-10.3f ", name,i,arr[i]);
            if ((i+1)%columnCount==0 || i+1== arr.length) {
                System.out.println();

            }
        }

    }
}