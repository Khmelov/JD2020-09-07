package by.it.shkatula.jd01_14;


import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

    private static final String FILENAME = "text.txt";
    public static final String TASK_B_TXT = "resultTaskB.txt";


    public static void main(String[] args) {
        String path = getPath(TaskB.class);
        String fullPath = path + FILENAME;
        System.out.println("words="+countWords(fullPath)+", "+"punctuation marks="+ countPunctuation(fullPath));
        int words=countWords(fullPath);
        int punctuationMarks=countPunctuation(fullPath);
        printToTxt(words,punctuationMarks,path);

    }

    private static int countPunctuation(String fullPath) {
        try (BufferedReader dis = new BufferedReader(
                new FileReader(fullPath))) {
            String line = dis.readLine();
            int count = 0;
            while (line != null) {
                Pattern pattern = Pattern.compile("[!.,;:?\\-]+");
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

    private static int countWords(String fullPath) {
        try (BufferedReader dis = new BufferedReader(
                new FileReader(fullPath))) {
            String line = dis.readLine();
            int word = 0;
            while (line != null) {
                Pattern pattern = Pattern.compile("[А-Яа-яЁё]+");
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    word++;
                }
                line = dis.readLine();
            }
            return word;
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
    private static void printToTxt(int word, int punctuationMark, String path) {
        try(PrintWriter printWriter = new PrintWriter(path +TASK_B_TXT))
        {
            printWriter.printf("words=%d, punctuation marks=%d", word, punctuationMark);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
