package by.it.drugov.jd01_15;

import java.io.*;
import java.util.Arrays;

public class TaskA {
    public static void main(String[] args) {
        int[][] matrix = getMatrix();
        String path = getPath(TaskA.class);
        try (PrintWriter pw = new PrintWriter(path)) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    pw.printf("%3d ", matrix[i][j]);
                }
                pw.println();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            while (reader.ready()) {
                System.out.println(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static int[][] getMatrix() {
        int[][] matrix = new int[6][4];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = (int) (Math.random() * 31 - 15);
            }
        }
        return matrix;
    }

    private static String getPath(Class<?> cl) {
        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String path = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        return src + path + "matrix.txt";
    }
}
