package by.it.mialeshka.jd01_12;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {
    public static void main(String[] args) {
        Map<Integer, String> arrW = new TreeMap<>();
        Scanner scanner = new Scanner(System.in);
        String str;
        Pattern pattern = Pattern.compile("[a-zA-Z]+['a-zA-Z]*");
        Random random = new Random();
        int key = random.nextInt();
        while (!(str = scanner.next()).equals("end")){
            Matcher matcher = pattern.matcher(str);
            while(matcher.find()) {
                String word = matcher.group();

                while (arrW.containsKey(key)){
                    key = random.nextInt();
                }
                arrW.put(key, word);
            }

        }
        System.out.println(arrW);


        Object[] keys = arrW.keySet().toArray();


        for (int i = keys.length-1; i >=0; i--) {
            key = (int) keys[i];
            if(Collections.frequency(arrW.values(), arrW.get(key)) > 1){
                arrW.remove(key);
            }

        }
        System.out.println(arrW);
    }
}
