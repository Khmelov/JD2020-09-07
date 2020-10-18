package by.it.hryntsaliou.jd01_15;


import java.io.*;

/**
 * @author Nikita Hryntsaliou
 */

class TaskB {
    public static void main(String[] args) {
        String filename = getPath(TaskB.class) + "TaskB.java";
        File file = new File(filename);
        StringBuilder codeText;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            char[] chars = new char[(int) file.length()];
            bufferedReader.read(chars);
            codeText = new StringBuilder(String.valueOf(chars));
        } catch (IOException e) {
            throw new RuntimeException();
        }
        deleteSingleComment(codeText);
        deleteMultiComment(codeText);
        String path = getPath(TaskB.class) + "TaskB.txt";
        try (PrintWriter printWriter = new PrintWriter(path)) {
            printWriter.print(codeText);
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

    //London is the capital of Great Britain
    //I want to break free
    //I want to break free
    //I wand to break free from your lies
    //You're so self satisfied i don't need you

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
//        char[] chars = new char[codeText.length()];
//        codeText.getChars(0, codeText.length(), chars, 0);
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
    /*Html это язык программирования,
    который объединяет людей по всему
    миру!!!
     */

    /*You've got something i need
    In this world full of people
    There's one killing me
     */

    private static String getPath(Class<TaskB> taskBClass) {
        String rootProject = System.getProperty("user.dir");
        String relativePath = taskBClass.getName()
                .replace(taskBClass.getSimpleName(), "")
                .replace(".", File.separator);
        return rootProject + File.separator + "src" + File.separator + relativePath;
    }
}