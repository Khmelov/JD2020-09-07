package by.it.yatsevich.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    private static String glass= new String("ауоыиэяюёеАУОЫИЭЯЮЕЁ");
    public static void main(String[] args) {
        Pattern pattern= Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher= pattern.matcher(Poem.text);
        while (matcher.find()){
            String word= matcher.group();
            int lenght=matcher.end()- matcher.start();
            if (equaleFirstLastLetter(word, glass,lenght)) System.out.println(word);
        }

    }

    private static boolean equaleFirstLastLetter(String word, String glass, int lenght) {

        return (glass.indexOf(word.charAt(0))<0&&glass.indexOf(word.charAt(lenght-1))>=0);

    }
}
