package by.it.adryneuski.jd01_15;


import java.io.*;

/**
 * @author Andrew D.
*/

class TaskB
{
    public static void main(String[] args)
    {
        String filename = getPath(TaskB.class) + "TaskB.java";
        File file = new File(filename);
        StringBuilder codText;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            char[] chars = new char[(int) file.length()];
            bufferedReader.read(chars);
            codText = new StringBuilder(String.valueOf(chars));
        } catch (IOException e) {
            throw new RuntimeException();
        }
        deleteSingleComment(codText);
        deleteMultiComment(codText);
        String path = getPath(TaskB.class) + "TaskB.txt";
        try (PrintWriter printWriter = new PrintWriter(path)) {
            printWriter.print(codText);
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

      private static void deleteMultiComment(StringBuilder codeText) {
        int length = codeText.length();
        for (int i = 0; i < codeText.length(); i++) {
            if (codeText.charAt(i) == '/' && codeText.charAt(i + 1) == '*') {
                int begin = i;
                for (int j = begin; j < codeText.length(); j++) {
                    if (codeText.charAt(j) == '*' && codeText.charAt(j + 1) == '/') {
                        int end = j + 1;
                        for (int k = begin; k <= end; k++) {
                            codeText.replace(k, k + 1, " ");
                            i--;
                        }
                        codeText.delete(begin, end+1);
                        i--;
                        codeText.setLength(length);
                        break;
                    }
                }
            }
        }
    }

    private static void deleteSingleComment(StringBuilder codeText) {
/*
        char[] chars = new char[codeText.length()];
        codeText.getChars(0, codeText.length(), chars, 0);
*/

        /*12351451
                adsfhadfha
                        afharehq
                        aerhaehrq*/


        int length = codeText.length();
        for (int i = 0; i < codeText.length(); i++) {
            if (codeText.charAt(i) == '/' && codeText.charAt(i + 1) == '/') {
                int begin = i;
                for (int j = begin; j < codeText.length(); j++) {
                    if (codeText.charAt(j) == '\n') {
                        int end = j;
                        for (int k = begin; k <= end; k++) {
                            if (k == end) break;
                            codeText.replace(k, k + 1, " ");
                        }
                        codeText.delete(begin, end);
                        i--;
                        codeText.setLength(length);
                        break;
                    }
                }
            }
        }
    }


    //получение пути к файлу
    //123456

    private static String getPath(Class<TaskB> taskBClass) {
        String rootProject = System.getProperty("user.dir");
        String relativePath = taskBClass.getName()
                .replace(taskBClass.getSimpleName(), "")
                .replace(".", File.separator);
        return rootProject + File.separator + "src" + File.separator + relativePath;
    }
}