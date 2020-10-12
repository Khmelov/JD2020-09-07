package by.it.adryneuski.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> myList = new ListA<>();
        List<String> arrList = new ArrayList<>();

        myList.add("First");arrList.add("First");
        myList.add("Two");arrList.add("Two");
        myList.add("Four");arrList.add("Four");
        System.out.println("myList:"+ myList+"\narList:"+arrList);

        myList.add(2,"Tree");arrList.add(2,"Tree");
        myList.add(0,"Start");arrList.add(0,"Start");
        System.out.println("myList:"+ myList+"\narList:"+arrList);

        myList.remove("Start");arrList.remove("Start");
        myList.remove(3);arrList.remove(3);
        System.out.println("myList:"+ myList+"\narList:"+arrList);

        System.out.println("myList(0):"+ myList.get(0)+"\narList(0):"+arrList.get(0));
    }
}
