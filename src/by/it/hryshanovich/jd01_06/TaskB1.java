package by.it.hryshanovich.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static String votes="уеэоаыяиюёУЕЭОАЫЯИЮЁ";
    public static void main(String[] args) {
        StringBuilder sb=new StringBuilder(Poem.text);
        Pattern pattern=Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher= pattern.matcher(Poem.text);
        while (matcher.find()){
            String word = matcher.group();
            if (cheskWord(word)){
                System.out.println(word);
            }
        }
    }
    private static boolean cheskWord (String word){
        return votes.indexOf(word.charAt(0))<0 &&
                votes.indexOf (word.charAt(word.length()-1))>=0;
    }
}
