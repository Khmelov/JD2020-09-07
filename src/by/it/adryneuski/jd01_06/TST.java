package by.it.adryneuski.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TST {
    public static void main(String[] args) {
        Pattern p1 = Pattern.compile("a+y");
        Matcher m1 = p1.matcher("aaay");
        boolean b = m1.matches();
        System.out.println(b);
    }
}
