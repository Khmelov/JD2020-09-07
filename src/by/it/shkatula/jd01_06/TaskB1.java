package by.it.shkatula.jd01_06;


import java.sql.SQLOutput;
import java.util.Locale;

public class TaskB1 {


    public static void main(String[] args) {
        String letter = "уеыаоэяиюё";
        String[] array = Poem.text.split("[\\n ,!\\-:.]");

        for (String s : array) {
            if (s.length() > 0) {
                char firstLetter = s.toLowerCase(new Locale("RU")).charAt(0);
                char lastLetter = s.charAt(s.length() - 1);
                letter.contains(String.valueOf(firstLetter));
                if (!letter.contains(String.valueOf(firstLetter)) && letter.contains(String.valueOf(lastLetter))) {
                    System.out.println(s);
                }
            }
        }

    }
}



