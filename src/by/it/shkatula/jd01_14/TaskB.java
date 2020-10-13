package by.it.shkatula.jd01_14;


import java.io.*;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

    private static final String FILENAME = "text.txt";

    public static void main(String[] args) {
        String path = getPath(TaskB.class);
        String fullPath = path + FILENAME;
        System.out.println(fullPath);
        System.out.println("punctuation marks="+readTxt(fullPath));



    }

    private static int readTxt(String fullPath) {
        try (BufferedReader dis = new BufferedReader(
                new FileReader(fullPath))) {
            String line = dis.readLine();
            int count = 0;
            while (line != null) {
                Pattern pattern = Pattern.compile("\\.{3,} | [!.,;:?\\-]");
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    count++;
                }
                line = dis.readLine();
            }
            return count;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static String getPath(Class<TaskB> taskBClass) {
        String rootProject = System.getProperty("user.dir");
        String relativePath = taskBClass
                .getName()
                .replace(taskBClass.getSimpleName(), "")
                .replace(".", File.separator);
        return rootProject + File.separator + "src" + File.separator + relativePath;
    }
}
