package by.it.yatsevich.jd01_15;

import java.io.*;
import java.util.Random;

class TaskA {
    public static void main(String[] args) {
        int [][] matrix=new int[6][4];
        Random random = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j= 0; j < matrix[i].length ; j++) {
                matrix[i][j]=-15 + random.nextInt(31);
            }
        }
        String path = getPath()+"matrix.txt";
        try(PrintWriter printWriter = new PrintWriter(path)) {
            for (int[] row : matrix) {
                for (int i : row) {
                    printWriter.printf("%3d ",i);
                }printWriter.println();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        try(BufferedReader reader =new BufferedReader(new FileReader(path))){
            while (reader.ready()){
                System.out.println(reader.readLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getPath() {
        String projectDir = System.getProperty("user.dir");
        String relativePath = TaskA.class.getName()
                .replace(TaskA.class.getSimpleName(), "")
                .replace(".", File.separator);
        return projectDir + File.separator + "src" + File.separator + relativePath;
    }
}
