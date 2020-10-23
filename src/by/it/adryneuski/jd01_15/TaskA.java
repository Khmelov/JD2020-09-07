package by.it.adryneuski.jd01_15;

import java.io.*;
import java.util.Random;

public class TaskA {
    public static void main(String[] args) {
        int[][] m = new int[6][4];
        Random rnd = new Random();
        for (int[] row : m) {
            for (int i = 0; i < row.length; i++) {
                row[i] = -15 + rnd.nextInt(31);
            }
        }
        String path = getPath(TaskA.class) + "matrix.txt";
        try (PrintWriter writer = new PrintWriter(path)) {
            for (int[] row : m) {
                for (int i : row) {
                    writer.printf("%3d ", i);
                }
                writer.println();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            while (reader.ready()) {
                System.out.println(reader.readLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getPath(Class<TaskA> taskAClass) {
        String rootProject = System.getProperty("user.dir");
        String relativePath = taskAClass
                .getName()
                .replace(taskAClass.getSimpleName(), "")
                .replace(".", File.separator);
        return rootProject + File.separator + "src" + File.separator + relativePath;
    }
}
