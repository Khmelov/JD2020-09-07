package by.it.trukhanovich.jd01_12;

import java.util.*;

public class TaskC1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Object, Object> map = new HashMap<>();
        for (; ; ) {
            String s = sc.next();
            if (s.equals("end")) break;
            long key=System.nanoTime();
            map.put(key,s);
        }
        System.out.println(map);
        //огурец помидор кабачок картошка огурец огурец end
        HashMap<Object, Object> map1 = new HashMap<>(expandHashMap(map));
//        System.out.println(map1);
        HashMap<Object, Object> map2 = new HashMap<>(expandHashMap(map1));
        System.out.println(map2);

    }

    private static HashMap<Object, Object>  expandHashMap(HashMap<Object, Object> map) {
        Set keys = map.keySet();
        System.out.println(keys);
        Iterator it = keys.iterator();
        HashMap<Object, Object> map1 = new HashMap<>();
        while (it.hasNext()){
            Object key= it.next();
            Object value=  map.get(key);
            if (map1.containsKey(value)) {continue;}
            else {map1.put(value,key);}
        }
        return map1;
    }


}



