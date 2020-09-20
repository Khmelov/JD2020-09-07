package by.it.adryneuski.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TST {
    public static void main(String[] args) {


        String input = "Hello";
        Pattern pattern = Pattern.compile("Hello");
        Matcher matcher = pattern.matcher(input);
        boolean found = matcher.matches();
        if(found)
            System.out.println("Найдено");
        else
            System.out.println("Не найдено");

    }
}
