package by.it.hryntsaliou.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class TaskB {

    static final String FILENAME = "text.txt";
    static final String TASK_B_TXT = "resultTaskB.txt";

    public static void main(String[] args) {
        int wordsCount = 0;
        int signsCount = 0;
        String path = getPath(TaskB.class);
        File fileRead = new File(path + FILENAME);
        File fileWrite = new File(path + TASK_B_TXT);
        FileReader is = null;
        FileWriter os = null;
        int b;
        StringBuilder line = new StringBuilder();
        try {
            is = new FileReader(fileRead);
            while ((b = is.read()) != -1) {
                line.append((char) b);
            }
            Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                wordsCount++;
            }

            Pattern pattern1 = Pattern.compile("[.!?,:;-]+");
            Matcher matcher1 = pattern1.matcher(line);
            while (matcher1.find()) {
                signsCount++;
            }
            String result;
            result = "words=" + wordsCount + ", punctuation marks=" + signsCount;
            System.out.println(result);
            fileWrite.createNewFile();
            os = new FileWriter(fileWrite);
            os.write(result);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static String getPath(Class<TaskB> taskBClass) {
        String rootProject = System.getProperty("user.dir");
        String relativePath = taskBClass.getName()
                .replace(taskBClass.getSimpleName(), "")
                .replace(".", File.separator);
        return rootProject + File.separator + "src" + File.separator + relativePath;
    }
}
