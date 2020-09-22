package by.it.trukhanovich.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    private static char [] glass= {'а', 'у', 'о', 'ы', 'и', 'э', 'я', 'ю', 'ё', 'е', 'А', 'У', 'О', 'Ы', 'И', 'Э', 'Я', 'Ю', 'Ё', 'Е',};
    public static void main(String[] args) {
        System.out.printf("Длинна строки гласных: %d\n", glass.length);
//        StringBuilder sb=new StringBuilder(Poem.text);
        Pattern p1= Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher m1= p1.matcher(Poem.text);
        while (m1.find()){
            String word= m1.group();
            int lenght=m1.end()- m1.start();
            boolean i= equaleFirstLastLetter(word, glass,lenght);
            if (i) System.out.println(word);
        }

    }

    private static boolean equaleFirstLastLetter(String word, char [] glass, int lenght) {
        boolean first = false;
        boolean last = false;
        lenght=lenght-1;
        for (int i = 0; i < glass.length; i++) {
            if (glass[i] == word.charAt(0)) first=true;
            if (glass[i] == word.charAt(lenght)) last=true;
        }
        if ((first==false) && (last==true)) {return true;}
        else return false;
    }
}
