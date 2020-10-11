package by.it.yatsevich.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

class TaskB2 {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        LinkedList<String> linkedList = new LinkedList<>();
        for (int i = 0; i < 4096; i++) {
            arrayList.add(i, "name" + i);
            linkedList.add(i, "name" + i);
        }
        System.out.println(process(arrayList));
        System.out.println(process(linkedList));

    }

    static String process(ArrayList<String> peoples) {
        for (;;){
                if (peoples.size()==1) break;
                Iterator<String> iterator = peoples.iterator();
                if (iterator.hasNext()) {
                    iterator.next();
                    if (iterator.hasNext()) {
                        iterator.next();
                        iterator.remove();
                    }else iterator.remove();
                }
        }
        String s = peoples.get(0);
        return s;
    }

    static String process(LinkedList<String> peoples) {
        for (;;){
            if (peoples.size()==1) break;
            Iterator<String> iterator = peoples.iterator();
            if (iterator.hasNext()) {
                iterator.next();
                if (iterator.hasNext()) {
                    iterator.next();
                    iterator.remove();
                }else iterator.remove();
            }
//             for (int i = 0; i < peoples.size(); i++) {
//                 if (i < peoples.size() - 1) peoples.remove(i + 1);
//             }
        }

        String first = peoples.getFirst();
        return first;
    }
}
