package by.it.trukhanovich.jd01_11;

import java.util.*;

public class Runner {
    public static void main(String[] args) {
        Set<String> strings = new HashSet<String>();
        strings.add("one");
        strings.add("one");
        strings.add("1");
        strings.add("2");
        strings.add("3");
        strings.add("4");
        strings.add("124");
        System.out.println(strings.toString());
        System.out.println("contains \"one\": "+strings.contains("one"));
        System.out.println("remove: "+strings.remove("5"));
        System.out.println("after remove:"+strings.toString());
        System.out.println("size: " +strings.size());
        System.out.println("isEmpty: "+strings.isEmpty());


        //my realization
        System.out.println("my realization ");
        SetC<String> objects = new SetC<>();
        objects.add("one");
        objects.add("one");
        objects.add("one");
        objects.add("1");
        objects.add("2");
        objects.add("3");
        System.out.println("after add: "+objects.toString());
        System.out.println("remove:"+objects.remove("123"));
        System.out.println("after remove: "+objects.toString());
        System.out.println("size: " +objects.size());
        System.out.println("isEmpty: "+objects.isEmpty());



//        List<String> listOk = new ArrayList<String>();
//        listOk.add("one");
//        listOk.add("2");
//        listOk.add("3");
//        listOk.add("4");
//        listOk.add("5");
//        listOk.add("6");
//        System.out.println(listOk);
//        System.out.println(listOk.size());
//        listOk.remove(2);
//        System.out.println(listOk);
//        System.out.println(listOk.size());
//        listOk.set(2,"new string");
//        System.out.println(listOk);
//        listOk.add(3,"123");
//        System.out.println(listOk);
//        listOk.addAll(listOk);
//        System.out.println(listOk);
////        ArrayList ggg=new ArrayList();
////        ggg.toArray()
//
//
//        //my realization
//        System.out.println("моя реализация");
//        ListB<Object> myListOk = new ListB<>();
//        myListOk.add("myOne");
//        myListOk.add("my1");
//        myListOk.add("my2");
//        myListOk.add("my3");
//        myListOk.add("my4");
//        myListOk.add("my5");
//        myListOk.add("my6");
//        System.out.println(myListOk);
//        System.out.println(myListOk.size());
//        System.out.println(myListOk.get(4));
//        myListOk.set(2,"myNewString");
//        System.out.println(myListOk);
//        myListOk.add(3,"new");
//        System.out.println(myListOk);
//        System.out.println("addAll");
//        System.out.println("Размер массива:"+myListOk.size());
//        myListOk.addAll(myListOk);
//        System.out.println(myListOk);
//        System.out.println("Размер массива:"+myListOk.size());




    }
}
