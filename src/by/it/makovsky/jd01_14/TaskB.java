package by.it.makovsky.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

    static final String FILE_NAME = "text.txt";
    public static final String TASK_B_TXT = "resultTaskB.txt";

    public static void main(String[] args) {
        String path=getPath(TaskB.class);
        String fileName=path+ FILE_NAME;
        int words=findWords(fileName);
        int marks=findMarks(fileName);
        printToTxt(words,marks,path);
        System.out.printf("words=%d, punctuation marks=%d", words, marks);


    }

    private static int findWords(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName)))
        {
            int words=0;
            while (br.ready()){
                String str=br.readLine();
                Pattern pattern = Pattern.compile("[А-Яа-яЁё]+");
                Matcher matcher= pattern.matcher(str);
                while (matcher.find()){
                    words++;}
            }
            return words;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static int findMarks(String fileName) {

        try (BufferedReader br = new BufferedReader(new FileReader(fileName)))
        {
            int punctuationMarks=0;
            while (br.ready()){
                String str=br.readLine();
                Pattern pattern = Pattern.compile("[-,.:!?]+");
                Matcher matcher= pattern.matcher(str);
                while (matcher.find()){
                    punctuationMarks++;}
            }
            return punctuationMarks;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getPath(Class<TaskB> taskBClass) {
        String rootProject = System.getProperty("user.dir");
        String path = taskBClass.getName().
                replace(taskBClass.getSimpleName(),"").
                replace(".", File.separator);
        return rootProject+File.separator+"src"+File.separator+path;
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