package by.it.stefankin.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {

        StringBuilder sb=new StringBuilder(Poem.text);
        Pattern pat=Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher mat= pat.matcher(Poem.text);
        while (mat.find()){
            String word= mat.group();
            proverka(word);
        }

    }
    private static void proverka(String word) {
       if (word.charAt(0)=='б'|| word.charAt(0)=='в'|| word.charAt(0)=='г'|| word.charAt(0)=='д'||word.charAt(0)=='ж'
               ||word.charAt(0)=='з'||word.charAt(0)=='к'||word.charAt(0)=='л'||word.charAt(0)=='м'
               ||word.charAt(0)=='н'||word.charAt(0)=='п'||word.charAt(0)=='р'||word.charAt(0)=='с'
               ||word.charAt(0)=='т'||word.charAt(0)=='ф'||word.charAt(0)=='х'||word.charAt(0)=='ц'
               ||word.charAt(0)=='ч'||word.charAt(0)=='ш'||word.charAt(0)=='щ'||word.charAt(0)=='Б'
               ||word.charAt(0)=='В'||word.charAt(0)=='Г'||word.charAt(0)=='Д'||word.charAt(0)=='Ж'
               ||word.charAt(0)=='З'||word.charAt(0)=='К'||word.charAt(0)=='Л'||word.charAt(0)=='М'
               ||word.charAt(0)=='Н'||word.charAt(0)=='П'||word.charAt(0)=='Р'||word.charAt(0)=='С'
               ||word.charAt(0)=='Т'||word.charAt(0)=='Ф'||word.charAt(0)=='Х'||word.charAt(0)=='Ц'
               ||word.charAt(0)=='Ч'||word.charAt(0)=='Ш'||word.charAt(0)=='Щ'||word.charAt(0)=='й'||
               word.charAt(0)=='Й')

          if   (word.charAt(word.length()-1)=='а'||word.charAt(word.length()-1)=='е'||word.charAt(word.length()-1)== 'ё'||
                  word.charAt(word.length()-1)== 'и'|| word.charAt(word.length()-1)=='о'||word.charAt(word.length()-1)== 'у'||
        word.charAt(word.length()-1)== 'ы'||word.charAt(word.length()-1)== 'э'||word.charAt(word.length()-1)== 'ю'||
                  word.charAt(word.length()-1)== 'я'||word.charAt(word.length()-1)== 'А'||word.charAt(word.length()-1)=='Е'||
                  word.charAt(word.length()-1)=='Ё'||word.charAt(word.length()-1)=='И'||word.charAt(word.length()-1)=='О'||
                  word.charAt(word.length()-1)=='У'||word.charAt(word.length()-1)=='Ы'||word.charAt(word.length()-1)=='Э'||
                  word.charAt(word.length()-1)=='Ю'||word.charAt(word.length()-1)=='Я')


        {
           System.out.println(word);
       }


    }



}
