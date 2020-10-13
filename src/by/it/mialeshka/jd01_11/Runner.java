package by.it.mialeshka.jd01_11;

import java.util.*;

public class Runner {
    public static void main(String[] args) {
        List<String > myList = new ListA<>();
        List<String> arList = new ArrayList<>();
        myList.add("First");
        arList.add("First");
        myList.add("Two");
        arList.add("Two");
        myList.add(null);
        arList.add(null);
        myList.add("Four");
        arList.add("Four");
        System.out.println("myList:" + myList + "\narList:" + arList);
        myList.add(1,"Five");
        arList.add(1, "Five");
        myList.add(1,"Five");
        arList.add(1, "Five");
        System.out.println("myList:" + myList + "\narList:" + arList);
        myList.remove(3);
        arList.remove(3);
        System.out.println("myList:" + myList + "\narList:" + arList);

        List<String > myListB = new ListB<>();
        myListB.add("First");
        myListB.add("First");
        myListB.add("Two");
        myListB.addAll(arList);
        System.out.println("myListB:"+myListB);

        Set<Short> a = new SetC();
        Set<Short> e = new HashSet<>();
        Set<Short> d = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            e.add((short) (i * 2));
            a.add((short) (i * 2));
        }
        d.add((short)2);
        d.add((short)18);
        d.add((short)3);
        d.add((short)3);
        a.removeAll(d);
        e.removeAll(d);
        System.out.println(a);
        System.out.println(e);

    }
}
