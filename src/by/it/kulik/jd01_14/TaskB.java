package by.it.kulik.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TaskB {
    public static void main(String[] args) {
        String src = System.getProperty("user.dir") + "/src/by/it/kulik/";
        String filename = src + "JD01_14/text.txt";
        File f = new File(filename);
        BufferedReader BR=null;
        int words = 0, marks = 0;
        try {
            BR = new BufferedReader(new FileReader(f));
            String res;
            while ((res=BR.readLine())!=null){
                Pattern p=Pattern.compile("[.!?,:;-]+");
                Matcher m=p.matcher(res);
                while(m.find()){
                    marks++;
                }
                Pattern p1=Pattern.compile("[а-яА-ЯёЁ]+");
                Matcher m1=p1.matcher(res);
                while(m1.find()){
                    words++;
                }
            }
            System.out.println();
            System.out.println("\npunctuation marks="+marks+" words="+words);
            } catch (IOException e) {
            System.err.println(" Ошибка файла:" + e);
        } finally {
            try {
                if ( BR!= null) {
                    BR.close();
                }
            } catch (IOException e) {
                System.err.println("ошибка закрытия:" + e);
            }
        }
    }
}