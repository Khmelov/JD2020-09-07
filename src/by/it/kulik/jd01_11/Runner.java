package by.it.kulik.jd01_11;

import by.it._akhmelev_.jd01_11.ListA;

import java.util.ArrayList;
import java.util.List;

public class Runner {

    public static void main(String[] args) {
        List<String> listOk=new ArrayList<>();
        listOk.add("One");
        listOk.add("2");
        listOk.add("3");
        listOk.add("4");
        listOk.add("5");
        System.out.println(listOk);
        listOk.remove(2);
        System.out.println(listOk);
        System.out.println(listOk.size());

        List<String> myList=new ListA<>();
        myList.add("One");
        myList.add("2");
        myList.add("3");
        myList.add("4");
        myList.add("5");
        System.out.println(myList);
        myList.remove(2);
        System.out.println(myList);
        System.out.println(myList.size());
    };
}
