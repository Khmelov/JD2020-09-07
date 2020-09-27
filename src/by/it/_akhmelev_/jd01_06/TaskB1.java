package by.it._akhmelev_.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {

    private static String  votes="уеэоаыяиюёУЕЭОАЫЯИЮЁ";
    public static void main(String[] args) {
        StringBuilder dynText = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(dynText);
        while (matcher.find()) {
            String word = matcher.group();
            if (checkWord(word)){
                System.out.println(word);
            }
        }
    }

    private static boolean checkWord(String word) {
        char first = word.charAt(0);
        int indexLastChar = word.length() - 1;
        char last = word.charAt(indexLastChar);
        return votes.indexOf(first)<0 && votes.indexOf(last)>=0;
    }
}
