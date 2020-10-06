package by.it.stefankin.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
       /* List<String> myList=new ListA<>();
        List<String> arrList=new ArrayList<>();

        myList.add("First");arrList.add("First");
        myList.add("Two");arrList.add("Two");
        myList.add("Three");arrList.add("Three");
        System.out.println("myList"+myList+"\narrList"+arrList);
        myList.add(1,"novy");
        System.out.println(myList);
        System.out.println(myList.indexOf("Two"));
        System.out.println(myList.get(3));
        System.out.println(myList.remove(2));
        System.out.println(myList);
        myList.remove("Three");
        System.out.println(myList);
*/
        List<Integer> lb = new ListB<>();
        lb.add(1);
        lb.add(2);
        lb.add(3);
        System.out.println(lb);
        lb.set(1,4);
        System.out.println(lb);
        lb.add(1,78);
        System.out.println(lb);














    }




}
