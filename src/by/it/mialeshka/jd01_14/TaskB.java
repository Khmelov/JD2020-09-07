package by.it.mialeshka.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    private static String dir(Class<?> clName){
        String path = System.getProperty("user.dir")+ File.separator + "src" + File.separator;
        String clDir = clName.getName().replace(clName.getSimpleName(), "").replace(".", File.separator);
        return path+clDir;
    }
    public static void main(String[] args) {
        int countD = 0;
        int countW = 0;
        Pattern patternW = Pattern.compile("[А-Яа-яЁё]+");
        Pattern patternD = Pattern.compile("[!?.:,-]+");
        try(BufferedReader reader = new BufferedReader(new FileReader(new File(dir(TaskB.class) + "text.txt")))){
            String i;
            while (reader.ready()){
                i = reader.readLine();
                Matcher matcherW = patternW.matcher(i);
                while (matcherW.find()){
                    countW++;
                }
                Matcher matcherD = patternD.matcher(i);
                while (matcherD.find()){
                    countD++;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.printf("words=%d, punctuation marks=%d", countW, countD);
        try(PrintWriter out = new PrintWriter(new FileWriter(dir(TaskB.class) + "resultTaskB.txt"))){
            out.printf("words=%d, punctuation marks=%d", countW, countD);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
