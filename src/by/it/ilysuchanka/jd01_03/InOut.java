package by.it.ilysuchanka.jd01_03;

public class InOut {
    static double[] getArray(String line) {
        String[] strArr = line.split("");
        double[] res = new double[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            res[i] = Double.parseDouble(strArr[i]);
        }
        return res;
    }

    static void printArray(double[] arr) {
        for (double element : arr) {
            System.out.print(element + " ");

        }
        System.out.println();
    }

    static void printArray(double[] arr, int columnCount) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[%-1d]=%-6.1f", "V", i, arr[i]);
        }
        System.out.println();
    }
}
