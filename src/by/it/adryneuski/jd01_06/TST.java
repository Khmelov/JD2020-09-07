package by.it.adryneuski.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TST {
    public static void main(String[] args) {
        String input = "Hello Java! Hello JavaScript! JavaSE 8";
        Pattern pattern = Pattern.compile("Java(\\w*)");
        Matcher matcher = pattern.matcher(input);
        boolean found = matcher.matches();
        while(matcher.find())
            System.out.println(matcher.group());

    }
}
