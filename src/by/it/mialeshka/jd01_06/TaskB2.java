package by.it.mialeshka.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[.]{3} [а-яё]");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()){
            int start = matcher.start();
            str.replace(start, start+3, "");
        }

        Pattern paternArr = Pattern.compile("[!.?]");
        String[] arrStr = paternArr.split(str);


        for (int i = 0; i < arrStr.length; i++) {
            arrStr[i] = arrStr[i].replaceAll("[\\n]+", " ");
            arrStr[i] = arrStr[i].replaceAll("\\p{Punct}+", "");
            arrStr[i] = arrStr[i].replaceAll("[ ]{2,}", " ");
            arrStr[i] = arrStr[i].trim();
        }

        for (int i = arrStr.length-1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if(arrStr[j].length() > arrStr[j+1].length()){
                    String val = arrStr[j];
                    arrStr[j] = arrStr[j+1];
                    arrStr[j+1] = val;
                }
            }
        }

        for (int i = 0; i < arrStr.length; i++) {
            System.out.println(arrStr[i]);
        }
    }
}

