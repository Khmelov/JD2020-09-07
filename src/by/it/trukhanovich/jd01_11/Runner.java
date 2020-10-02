package by.it.trukhanovich.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> listOk = new ArrayList<String>();
        listOk.add("one");
        listOk.add("2");
        listOk.add("3");
        listOk.add("4");
        listOk.add("5");
        listOk.add("6");
        System.out.println(listOk);
        System.out.println(listOk.size());
        listOk.remove(2);
        System.out.println(listOk);
        System.out.println(listOk.size());

        //my realization
        System.out.println("моя реализация");
        ListB<Object> myListOk = new ListB<>();
        myListOk.add("myOne");
        myListOk.add("my1");
        myListOk.add("my2");
        myListOk.add("my3");
        myListOk.add("my4");
        myListOk.add("my5");
        System.out.println(myListOk);
        System.out.println(myListOk.size());
        System.out.println(myListOk.get(4));



    }
}
