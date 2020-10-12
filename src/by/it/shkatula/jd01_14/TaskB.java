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
        String fileName = path + FILENAME;
        System.out.println(fileName);


        }
    private static void readTxt(String fileName) {
        try (DataInputStream dis = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(fileName)))) {
            while (dis.available() > 0) {

                Pattern pattern = Pattern.compile("[!.,;:?\\-]");
                Matcher matcher = pattern.matcher((CharSequence) dis);
                int count = 0;
                while (matcher.find()){
                    count++;
                    System.out.println(count);
                }
            }
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
