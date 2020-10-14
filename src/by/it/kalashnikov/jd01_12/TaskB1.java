package by.it.kalashnikov.jd01_12;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class TaskB1 {
    public static void main(String[] args) {
        Map<String, Integer> hashMap = new HashMap<>();
        Pattern pattern = Pattern.compile("[a-zA-Z\']+");
        Matcher matcher = pattern.matcher(Text2.text);
        while (matcher.find()) {
            String s = matcher.group();
            if (s.equals("end"))
                break;
            if (hashMap.containsKey(s)) {
                Integer value = hashMap.get(s);
                hashMap.put(s, value + 1);
            }
            if (!hashMap.containsKey(s)) {
                hashMap.put(s, 1);
            }
        }
        System.out.println(hashMap);
    }
}
