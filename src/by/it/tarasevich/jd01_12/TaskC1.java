package by.it.tarasevich.jd01_12;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class TaskC1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Object, Object> map = new HashMap<>();
        for (; ; ) {
            String stringa = scanner.next();
            if (stringa.equals("end")) break;
            long key = System.nanoTime();
            map.put(key, stringa);
        }
        System.out.println(map);

        HashMap<Object, Object> map1 = new HashMap<>(expandHashMap(map));

        HashMap<Object, Object> map2 = new HashMap<>(expandHashMap(map1));
        System.out.println(map2);

    }

    private static HashMap<Object, Object> expandHashMap(HashMap<Object, Object> map) {
        Set keys = map.keySet();
        System.out.println(keys);
        Iterator it = keys.iterator();
        HashMap<Object, Object> map1 = new HashMap<>();
        while (it.hasNext()) {
            Object key = it.next();
            Object value = map.get(key);
            if (map1.containsKey(value)) {
            } else {
                map1.put(value, key);
            }
        }
        return map1;
    }

}
