package by.it.yatsevich.jd01_12;

import java.util.*;

public class TaskB1 {
    public static void main(String[] args) {
        HashMap<String, Integer> text = new HashMap<>();
        Scanner scan= new Scanner(System.in);
        scan.useDelimiter("[/\\s\\.—,:;?(){}]");
        String s=scan.next();
        do {
            if (!text.containsKey(s)){
                text.put(s,1);
            }else text.put(s, text.get(s) + 1);;
        }while (!(s=scan.next()).equals("end"));
        System.out.println(text);
    }
}
