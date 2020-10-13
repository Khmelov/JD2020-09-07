package by.it.yatsevich.jd01_12;

import java.util.*;

public class TaskC1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> temp = new ArrayList<>();
        HashMap<Long, String> textMap = new HashMap<>();
        String str;
        scan.useDelimiter("[/\\s—,:;?(){}]");
        while (!(str = scan.nextLine()).equals("end")) {
            temp.add(str);
        }

        for (String s : temp) {
            long value = 123 + (int) (Math.random() * 1000000);
            if (textMap.containsKey(value)) {
                value += 1;
                textMap.put(value, s);
            }
            textMap.put(value, s);
        }
        System.out.println(textMap);
        textMap.entrySet().stream().sorted(Map.Entry.comparingByValue());
//        System.out.println(textMap);
        Iterator<Map.Entry<Long, String>> iterator = textMap.entrySet().iterator();
        HashSet<String> objects = new HashSet<>();
        while (iterator.hasNext()) {
            Map.Entry<Long, String> next = iterator.next();
            if (!objects.add(next.getValue())) iterator.remove();
        }
        System.out.println(textMap);
    }
}


