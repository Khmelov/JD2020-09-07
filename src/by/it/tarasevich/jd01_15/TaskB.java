package by.it.tarasevich.jd01_15;

import java.io.*;

/**
 *
 * javadoc
 *
 *
 *
 * **/



public class TaskB {
    /* comments
     *
     **/
    public static void main(String[] args) {
        String path = getPath().concat(TaskB.class.getSimpleName()).concat(".java");

        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            while (bufferedReader.ready()) {
                stringBuilder.append(bufferedReader.readLine());
                stringBuilder.append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String s = stringBuilder.toString();

        int b;
        StringBuilder test = new StringBuilder();
        try (final BufferedReader bufferedReader = new BufferedReader(new StringReader(s))) {
            boolean a1 = false;
 //однострочный комментарий
            boolean comment = false;
            while ((b = bufferedReader.read()) != -1) {
                if (!comment) {
                    test.append((char) b);
                }
                if (!comment && a1 && b != '*') {
                    a1 = false;
                    continue;
                }
                if (!comment && b == '/') {
                    a1 = true;
                    continue;
                }
                if (!comment && (b == '*') && (a1 = true)) {
                    comment = true;
                    a1 = false;
                    test.delete(test.length() - 3, test.length()).append("\n");
                }
// одностройчный комментарий номер два
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String s1 = test.toString();
        StringBuilder result = new StringBuilder();
        try (final BufferedReader bufferedReader = new BufferedReader(new StringReader(s1))) {
            boolean b1 = false;
            while ((b = bufferedReader.read()) != 1) {
                result.append((char) b);
                if (b1 && b != '/') {
                    b1 = false;
                    continue;
                }
                if (b == '/') {
                    if (b1 = true) {
                        continue;
                        /* comments
                         *
                         **/

                    }
                    if (b1 = true) {
                        result.delete(test.length() - 2, test.length()).append("\n");
                    }
                }
            }
            System.out.println(result);
            printTXT(result, getPath().concat(TaskB.class.getSimpleName()).concat(".txt"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getPath() {
        String rootProgect = System.getProperty("user.dir");
        String path = TaskB.class.getName().replace(TaskB.class.getSimpleName(), "").
                replace(".", File.separator);

        return rootProgect + File.separator + "srs" + File.separator + path;
    }

    private static void printTXT(StringBuilder stringBuilder, String path) {
        try (PrintWriter printWriter = new PrintWriter(path)) {
            printWriter.println(stringBuilder);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
