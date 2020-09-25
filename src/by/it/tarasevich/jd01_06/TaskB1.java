package by.it.tarasevich.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {



        private static String  glasnue="ауоыиэяюёеАИУОЫЭЯЮЁЕ";

    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher= pattern.matcher(text);
        while (matcher.find()){
            String word = matcher.group();
            if (checword(word)){
                System.out.println(word);
            }

        }
    }

    private static boolean checword(String word) {
        char first= word.charAt(0);
        char last = word.charAt(word.length()-1);

        return glasnue.indexOf(first)<0 && glasnue.indexOf(last)>=0;

    }

}



