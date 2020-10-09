package by.it.trukhanovich.jd01_14;

import java.io.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

    static final String FILE_NAME = "text.txt";
    public static final String TASK_B_TXT = "resultTaskB.txt";

    public static void main(String[] args) {
        String path=getPath(TaskB.class);
        String fileName=path+ FILE_NAME;
        System.out.println(fileName);
        //        StringBuilder sb=new StringBuilder();

        int word=checkWords(fileName);
        int punctuationMark=checkMarks(fileName);
        printToTxt(word,punctuationMark,path);
        System.out.printf("words=%d, punctuation marks=%d", word, punctuationMark);


    }

    private static int checkWords(String fileName) {
        try (BufferedReader is = new BufferedReader(new FileReader(fileName)))
        {
            int word=0;
            while (is.ready()){
                String s=is.readLine();
                Pattern words = Pattern.compile("[А-Яа-яЁё]+");
                Matcher m1= words.matcher(s);
                while (m1.find()){
                    word++;}
            }
            return word;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static int checkMarks(String fileName) {

        try (BufferedReader is = new BufferedReader(new FileReader(fileName)))
        {
            int punctuationMark=0;
            while (is.ready()){
                String s=is.readLine();
                Pattern punctuationMarks = Pattern.compile("[-,.:!?]+");
                Matcher m1= punctuationMarks.matcher(s);
                while (m1.find()){
                    punctuationMark++;}
            }
            return punctuationMark;
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
