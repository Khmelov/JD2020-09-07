package by.it.hryntsaliou.jd01_03;

public class InOut {
    static double[] getArray(String line) {
        String[] stringsArray = line.split(" ");
        double[] result = new double[stringsArray.length];
        for (int i = 0; i < stringsArray.length; i++) {
            result[i] = Double.parseDouble(stringsArray[i]);
        }
        return result;
    }

    static void printArray(double[] arr) {
        for (double element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    static void printArray(double[] arr, String name, int columnCount) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d]=%-8.5f ", name, i, arr[i]);
            if ((i + 1) % columnCount == 0 || (i + 1) == arr.length)
                System.out.println();
        }
    }

    static void printMatrixAndVector(double[][] mat, double[] vec, double[] res) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.printf("A" + "[%1d,%1d]=%-6.1f ", i, j, mat[i][j]);
            }
            System.out.println();
        }
        System.out.println();

        for (int i = 0; i < vec.length; i++) {
            System.out.printf("B" + "[%1d]=%-6.1f ", i, vec[i]);
            System.out.println();
        }
        System.out.println();

        for (int i = 0; i < res.length; i++) {
            System.out.printf("C" + "[%1d]=%-6.1f ", i, res[i]);
            System.out.println();
        }
        System.out.println();
    }
}

