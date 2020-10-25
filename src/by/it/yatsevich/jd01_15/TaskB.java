package by.it.yatsevich.jd01_15;

import java.io.*;
import java.util.ArrayList;

/**
 * Bla bla
 * Bla bla
 * Bla bla
 * Bla bla
 * Bla bla
 *
 * @author mu11er
 * @version old
 */
class TaskB {
    public static void main(String[] args) {

//Print to console "Hello!"

//Print to console "Hello, world!"


        /*Bla bla*/

        /*Some text
         * more text
         * and more
         *
         * */
        StringBuilder strB = new StringBuilder();
        String delimiter = "";
        String path = getPath() + "TaskB.java";
        ArrayList<String> strings = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            while (bufferedReader.ready()) {
                strB.append(bufferedReader.readLine()).append(delimiter).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        deleteSingleComment(strB);
        deleteMultiComment(strB);

        try (BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(getPath() + "TaskB.txt"))) {
            bufferedWriter.append(strB);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void deleteSingleComment(StringBuilder lines) {

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


    private static void deleteMultiComment(StringBuilder lines) {
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
