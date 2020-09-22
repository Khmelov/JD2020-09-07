package by.it.trukhanovich.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    private static String glass= new String("ауоыиэяюёеАУОЫИЭЯЮЕЁ");
    public static void main(String[] args) {
        Pattern p1= Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher m1= p1.matcher(Poem.text);
        while (m1.find()){
            String word= m1.group();
            int lenght=m1.end()- m1.start();
            if (equaleFirstLastLetter(word, glass,lenght)) System.out.println(word);
        }

    }

    private static boolean equaleFirstLastLetter(String word, String glass, int lenght) {

        return (glass.indexOf(word.charAt(0))<0&&glass.indexOf(word.charAt(lenght-1))>=0);

    }
}
