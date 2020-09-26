package by.it.mialeshka.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {

    private static boolean needWord(String word){
        String vowels = "а,о,и,е,ё,э,ы,у,ю,я,А,О,И,Е,Ё,Э,Ы,У,Ю,Я";
       char first = word.charAt(0);
       char last = word.charAt(word.length()-1);

        return vowels.indexOf(first) < 0 && vowels.indexOf(last) >= 0;
    }

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()){
            String word = matcher.group();
            boolean isNeed = needWord(word);

            if (isNeed) System.out.println(word);
        }
    }
}
