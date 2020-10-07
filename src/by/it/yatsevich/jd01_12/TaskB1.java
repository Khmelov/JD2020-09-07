package by.it.yatsevich.jd01_12;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        Map<String, Integer> text = new HashMap<>();
        Scanner scan= new Scanner(System.in);
        String strings;
        Pattern pattern= Pattern.compile("[a-zA-Z']+");
        String s=scan.next();
        Integer value=1;
        while (!s.equals("end")){
            if (text.containsKey(s)==true){
                text.replace(s,value,value+1);
            }else if (!text.containsKey(s))text.put(s,value);
        }
        System.out.println(text);
    }
}
