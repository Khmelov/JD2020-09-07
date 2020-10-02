package by.it.trukhanovich.jd01_06;

import java.util.Arrays;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC2 {
    public static void main(String[] args) {
        String [] arrayWord=getArrayWord(Poem.text);

        long startSlow=System.nanoTime();
        String resultSlow = slow(Poem.text);
        long finishSlow=System.nanoTime();
        long durationSlow=(finishSlow-startSlow)/1000000;
        System.out.printf("Длинна resultSlow=%d символа;",resultSlow.length());
        System.out.printf("Время выполнения resultSlow=%d мс;\n",durationSlow);
        System.out.println(resultSlow);
        long startFast=System.nanoTime();
        String resultFast= fast(Poem.text);
        long finishFast=System.nanoTime();
        long durationFast=(finishFast-startFast)/1000000;
        System.out.printf("Длинна resultFast=%d символа;" ,resultFast.length());
        System.out.printf("Время выполнения resultFast=%d мс;",durationFast);
        System.out.println(resultFast);
        System.out.printf("Время выполнения resultFast=%d мс;",durationFast);
    }

    private static String fast(String text) {
        String [] arrayWord=getArrayWord(Poem.text);
        StringBuilder s=new StringBuilder (" ");
        Random random=new Random(18);
        do {
            int i= (int)random.nextInt((arrayWord.length-1));
            s=s.append(arrayWord[i]);
            s=s.append(" ");
        } while (s.length()<=100000);
        String fast=s.toString();
         return fast;
    }

//    private static String slow(String text) {
//        String s=new String("привет ");
//        do {
//            s=s.concat(text);
//        } while (s.length()<=100000);
//        return s;
//    }
    private static String slow(String  text) {
        String [] arrayWord=getArrayWord(Poem.text);
        Random random=new Random(18);
        String s=new String(" ");
        do {
            int i= (int)random.nextInt((arrayWord.length-1));
            s=s.concat(arrayWord[i]);
            s=s.concat(" ");
        } while (s.length()<=100000);
        return s;
    }

    private static String[] getArrayWord(String text) {
        String [] w =new String[1];
        StringBuilder sb = new StringBuilder(text);
        Pattern p1= Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher m1= p1.matcher(text);
        int i=0;
        while (m1.find()){
            w[i]=m1.group();
            w= Arrays.copyOf(w,w.length+1);
            i++;
        }

        return w;
    }
}
