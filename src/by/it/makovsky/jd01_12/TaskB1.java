package by.it.makovsky.jd01_12;

import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TaskB1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text;
            Map<String, Integer> occurrences = new HashMap<>();
        while (!(text=sc.next()).equals("end")) {
            List<String> list = Arrays.asList(text.split("[\\,?—;:.\\s]"));
            for ( String word : list ) {
                Integer oldCount = occurrences.get(word);
                if ( oldCount == null ) {
                    oldCount = 0;
                }
                occurrences.put(word, oldCount+1);
            }
        }
            System.out.println(occurrences.entrySet());
    }
}
