package by.it.makovsky.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> myList=new ListA<>();
        List<String> arrList=new ArrayList<>();
        //add
        myList.add("One"); arrList.add("One");
        myList.add("Two"); arrList.add("Two");
        myList.add("Three"); arrList.add("Three");
        System.out.println("myList"+myList+"\narrList"+arrList);
        //remove
        myList.remove(1); arrList.remove(1);
        System.out.println("myList"+myList+"\narrList"+arrList);
        //get
        System.out.println("myList[0]: "+myList.get(0)+"\narrList[0]: "+arrList.get(0));
    }
}
