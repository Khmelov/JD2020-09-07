package by.it.tarasevich.jd01_15;

import java.io.*;
import java.util.Random;

public class TaskA {
    public static void main(String[] args) throws IOException {
        int [][] m = new int[6][4];
        Random random = new Random();
        for (int [] row: m ) {
            for (int i = 0; i < row.length ; i++) {
                row[i] = -15 + random.nextInt(31);
            }
        }
        String path = getPath(TaskA.class)+ "matrix.txt";
        try (PrintWriter writer = new PrintWriter(path)){
            for (int[] row: m){
                for (int i: row){
                    writer.printf("%3d ",i);
                }
                writer.println();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException();
        }
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))){
            while (bufferedReader.ready()){
                System.out.println(bufferedReader.readLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getPath(Class<TaskA> taskAClass) {
        String rootProject = System.getProperty("user.dir");
        String relativePath = taskAClass.getName()
                                        .replace(taskAClass.getSimpleName(),"")
                                        .replace(".", File.separator);
        return rootProject+File.separator+"src"+File.separator+relativePath;
    }
}
