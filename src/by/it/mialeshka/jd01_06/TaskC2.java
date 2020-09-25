package by.it.mialeshka.jd01_06;

import java.util.regex.Pattern;

public class TaskC2 {
    public static void main(String[] args) {
        StringBuilder strB = new StringBuilder(Poem.text);
        long lStartTime = System.nanoTime();
        String resultSlow = slow(strB.toString());
        long lEndTime = System.nanoTime();
        System.out.println(resultSlow);
        System.out.println((lEndTime-lStartTime)/1000000.0);
        lStartTime = System.nanoTime();
        String  resultFast= fast(strB.toString());
        lEndTime = System.nanoTime();
        System.out.println(resultFast);
        System.out.println((lEndTime-lStartTime)/1000000.0);

    }

    static String slow (String text){
        Pattern pattern = Pattern.compile("[^а-яА-Яёё]+");
        String[] arrWord = pattern.split(text);

        String result ="";
        int i = arrWord.length-1;
        while (result.length() < 100001){
            result = result + " " +arrWord[i];
            i--;

            if(i == -1)
                i=arrWord.length-1;

        }

        return  result.trim();
    }

     static String fast (String text){
         Pattern pattern = Pattern.compile("[^а-яА-Яёё]+");
        String[] arrWord = pattern.split(text);

        StringBuilder result = new StringBuilder("");
        int i = arrWord.length-1;
         while (result.length() < 100001){
            result = result.insert(result.length(), " ");
            result = result.insert(result.length(), arrWord[i]);
            i--;

             if(i == -1)
                 i=arrWord.length-1;
        }

        return  result.toString().trim();
    }
}
