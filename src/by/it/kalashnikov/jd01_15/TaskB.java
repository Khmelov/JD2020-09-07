package by.it.kalashnikov.jd01_15;
/**
 * @author Kalashnikov
 * @see All comments
 */

import java.io.*;

class TaskB {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        String str1;
        String str2 = "";
        try (BufferedReader bufferedReader = new BufferedReader(
                new FileReader(
                        new File(dir(TaskB.class) +
                                File.separator + TaskB.class.getSimpleName() +
                                ".java")))) {
            while ((str1 = bufferedReader.readLine()) != null) {
                sb.append(str2).append(str1);
                str2 = "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
/*
Какой-то многострочный комментарий под
номером 1
*/
        deleteComments(sb, dir(TaskB.class) + File.separator + TaskB.class.getSimpleName() + ".txt");
    }
//    Здесь есть первый однострочный кооментарий, ты его не видишь а он есть.
    private static String dir(Class<?> className) {
        return System.getProperty("user.dir") + File.separator + "src" + File.separator
                + className.getName().replace(className.getSimpleName(), "").
                replace(".", File.separator);
    }

    private static void deleteComments(StringBuilder clearStr, String pathFile) {
        boolean oneLineComment = false;
        boolean multilineComment = false;
        try (PrintWriter addInFile = new PrintWriter(new FileWriter(pathFile))) {
            for (int i = 0; i < clearStr.length(); i++) {
                char charRite = clearStr.charAt(i);
                if (i + 1 < clearStr.length() && charRite == '/' && clearStr.charAt(i + 1) == '/')
                    oneLineComment = true;
                if (i + 1 < clearStr.length() && charRite == '/' && clearStr.charAt(i + 1) == '*')
                    multilineComment = true;
//    Здесь есть второй однострочный кооментарий, ты его не видишь а он есть.
                if (!oneLineComment && !multilineComment) {
                    addInFile.print(charRite);
                    System.out.print(charRite);
                }
/*
Какой-то многострочный комментарий под
номером 2
*/
                if (oneLineComment && charRite == '\n') {
                    oneLineComment = false;
                    addInFile.println();
                    System.out.println();
                }
                if (i - 1 >= 0 && multilineComment && charRite == '/' && clearStr.charAt(i - 1) == '*') {
                    multilineComment = false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
/*
Какой-то многострочный комментарий под
номером 3
*/
    }
}
