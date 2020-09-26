package by.it.adryneuski.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {

    private static final String Glas = "АаиИУуЕеЁёЫыэЭОоЮюЯя";

    public static void main(String[] args) {

        //StringBuilder sb = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher m1 = pattern.matcher(Poem.text);

        while (m1.find()) {
            String word = m1.group();
            if (CheckWord(word)) {
                System.out.println(word);
            }
        }


    }

    private static boolean CheckWord(String word) {
        return Glas.indexOf(word.charAt(0)) < 0 && Glas.indexOf(word.charAt(word.length() - 1)) >= 0;

    }

}