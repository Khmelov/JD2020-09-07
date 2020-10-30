package by.it.hryntsaliou.jd01_15;

import java.io.*;

class TaskA {
    public static void main(String[] args) {
        int[][] matrix = new int[6][4];
        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < matrix[0].length; cols++) {
                matrix[rows][cols] = (int) (Math.random() * 31) - 15;
            }
        }
        String path = getPath(TaskA.class) + "matrix.txt";
        try (PrintWriter printWriter = new PrintWriter(path)) {
            for (int rows = 0; rows < matrix.length; rows++) {
                for (int cols = 0; cols < matrix[0].length; cols++) {
                    printWriter.printf("%3d ", matrix[rows][cols]);
                }
                printWriter.println();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException();
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            while (reader.ready()) {
                System.out.println(reader.readLine());
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    private static String getPath(Class<TaskA> taskAClass) {
        String rootProject = System.getProperty("user.dir");
        String relativePath = taskAClass.getName()
                .replace(taskAClass.getSimpleName(), "")
                .replace(".", File.separator);
        return rootProject + File.separator + "src" + File.separator + relativePath;
    }

}