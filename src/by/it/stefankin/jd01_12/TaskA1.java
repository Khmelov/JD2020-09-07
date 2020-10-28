package by.it.stefankin.jd01_12;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TaskA1 {

    private List<Integer> ocenki =new ArrayList<Integer>();

    public static void main(String[] args) {

        TaskA1 instn=new TaskA1();
        for (int i = 0; i < 25; i++) {
            instn.ocenki.add((int)(Math.random()*10+1));

        }
        System.out.println(instn.ocenki);
        clearBad(instn.ocenki);

    }
    static void clearBad(List<Integer> grades) {
        Iterator<Integer> iter= grades.iterator();
        while (iter.hasNext()) {
            if (iter.next()<4) iter.remove();

        }
        System.out.println(grades);
    }

}

