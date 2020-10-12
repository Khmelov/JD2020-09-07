package by.it.mialeshka.jd01_12;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        Map<String, Integer> arrW = new HashMap<String, Integer>();
        Scanner scanner = new Scanner(System.in);
        String str;
        Pattern pattern = Pattern.compile("[a-zA-Z]+['a-zA-Z]*");
        while (!(str = scanner.next()).equals("end")){
            Matcher matcher = pattern.matcher(str);
            while(matcher.find()) {
                String word = matcher.group();
                if(arrW.containsKey(word))
                    arrW.put(word, arrW.get(word)+1);
                else
                    arrW.put(word, 1);
            }

        }
        System.out.println(arrW);
    }
}
