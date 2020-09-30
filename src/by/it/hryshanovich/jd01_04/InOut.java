package by.it.hryshanovich.jd01_04;

public class InOut {
    public InOut() {
    }

    static double[] getArray(String line) {
        String[] strArr = line.split(" ");
        double[] res = new double[strArr.length];

        for(int i = 0; i < strArr.length; ++i) {
            res[i] = Double.parseDouble(strArr[i]);
        }

        return res;
    }

    static void printArray(double[] arr) {
        double[] var1 = arr;
        int var2 = arr.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            double element = var1[var3];
            System.out.print(element + " ");
        }

        System.out.println();
    }

    static void printArray(double[] arr, String name, int columnCount) {
        for(int i = 0; i < arr.length; ++i) {
            System.out.printf("%s[% -3d]=%-10.4f ", name, i, arr[i]);
            if ((i + 1) % columnCount == 0 || i + 1 == arr.length) {
                System.out.println();
            }
        }

        System.out.println();
    }

    public static void ark(double[][] m) {
        for(int i = 0; i < m.length; ++i) {
            for(int j = 0; j < m[0].length; ++j) {
                System.out.printf("%-7.4f", m[i][j]);
            }

            System.out.println();
        }

        System.out.println();
    }
}
