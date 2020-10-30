package by.it.tarasevich.jd01_15;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * javadoc
 *
 *
 *
 * **/



public class TaskB {

    public static void main(String[] args) {


//Comment second one string too


        /*
        *
        * four strings for comments
        * */

        StringBuilder strB = new StringBuilder();
        String delimiter = "";
        String path = getPath() + "TaskB.java";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            while (bufferedReader.ready()) {
                strB.append(bufferedReader.readLine()).append(delimiter).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//Comment first one string

        clearSingleComment(strB);
        clearMultiCommentsForCode(strB);

        try (BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(getPath() + "TaskB.txt"))) {
            bufferedWriter.append(strB);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        /*Some text
         * five strings for comments
         *
         *
         * */
    }

    private static void clearSingleComment(StringBuilder lines) {

        for (int i = 0;i < lines.length();i++) {
            if (lines.charAt(i) == '/' && lines.charAt(i + 1) == '/') {
                for (int j = i; j < lines.length(); j++) {
                    if (lines.charAt(j) == '\n') {
                        lines.delete(i, j);
                        System.out.println(lines);
                        break;
                    }
                }
            }
        }
    }


    private static void clearMultiCommentsForCode(StringBuilder lines) {
        for (int i = 0;i < lines.length();i++) {
            if (lines.charAt(i) == '/' && lines.charAt(i + 1) == '*') {
                for (int j = i; j < lines.length(); j++) {
                    if (lines.charAt(j) == '*' && lines.charAt(j + 1) == '/') {
                        lines.delete(i, j + 2);
                        System.out.println(lines);
                        break;
                    }
                }
            }

        }

    }

    private static String getPath() {
        String projectDir = System.getProperty("user.dir");
        String relativePath = TaskB.class.getName()
                .replace(TaskB.class.getSimpleName(), "")
                .replace(".", File.separator);
        return projectDir + File.separator + "src" + File.separator + relativePath;
    }

}

