package by.it.mialeshka.jd01_15;

import java.io.*;

public class TaskA {
    private static String dir (Class<?> className){
        return System.getProperty("user.dir") + File.separator + "src" + File.separator
                      + className.getName().replace(className.getSimpleName(), "").replace(".", File.separator);
    }

    public static void main(String[] args) {
        int[][] arrInt = new int[6][4];
        try(PrintWriter printWriter = new PrintWriter(new FileWriter(dir(TaskA.class)+"matrix.txt"))){
            for (int i = 0; i < arrInt.length; i++) {
                for (int j = 0; j < arrInt[0].length; j++) {
                    arrInt[i][j] = (int)((Math.random()*31)-15);
                    printWriter.printf("%3d ", arrInt[i][j]);
                }
                printWriter.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(BufferedReader bufferedReader= new BufferedReader(new FileReader(dir(TaskA.class)+"matrix.txt"))){
            String str;
            while ((str = bufferedReader.readLine()) != null){
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
