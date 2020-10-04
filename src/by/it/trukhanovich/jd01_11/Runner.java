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
        strings.add(null);
        strings.add("124");
        System.out.println(strings.toString());
        System.out.println("contains \"one\": "+strings.contains("one"));
        System.out.println("remove: "+strings.remove(null));
        System.out.println("after remove:"+strings.toString());
        System.out.println("size: " +strings.size());
        System.out.println("isEmpty: "+strings.isEmpty());
        Set<String> strings1 = new HashSet<String>();
        strings1.add("one");
        strings1.add("four");
        strings1.add("five");
        strings1.add("six");
//        strings1.add("1");
//        strings1.add(null);
        strings1.add("2");
        Set<String> strings2 = new HashSet<String>();
        strings2.add("one");
        strings2.add("four");
        strings2.add("five");
        strings2.add("six");
        strings2.add("1");
        strings2.add("2");
        strings2.add("3");
//        strings2.add(null);
        System.out.println("addAll: "+strings.addAll(strings1));
        System.out.println("strings: "+strings.toString());
//        strings.removeAll(strings2);
//        System.out.println("strings after removeAll strings2: "+strings.toString());
        System.out.println("containsAll: " + strings.containsAll(strings2));
        System.out.println("removeAll: "+strings.removeAll(strings));
        System.out.println(strings.toString());



        //my realization
        System.out.println("==============================");
        System.out.println("my realization ");
        SetC<String> objects = new SetC<>(); //создание коллекции
        //заполнение коллекции
        objects.add("one");
        //получение возращаемого значения false при попытке добавить повторящийся элемент
        System.out.println(objects.add("one"));
        objects.add("one");
        objects.add("one");
        //получение возращаемого значения true при попытке добавить уникальный элемент
        System.out.println(objects.add("1"));
        objects.add("2");
        objects.add("3");
        objects.add(null);
        //печать полученной коллекции
        System.out.println("after add: "+objects.toString());
        //тест метода remove
//        System.out.println("remove:"+objects.remove(null));
        System.out.println("after remove: "+objects.toString());
        //тест метода size
        System.out.println("size: " +objects.size());
        //тест метода isEmpty
        System.out.println("isEmpty: "+objects.isEmpty());
        //печать коллекции которую необходимо добавит
        System.out.println("strings1: "+strings1.toString());
        //печать true/false если что-то добавилось/ничего не добавилось
        System.out.println("addAll: "+objects.addAll(strings1));
        //печать полученного объекта
        System.out.println("objects: "+objects.toString());
        System.out.println("size: " +objects.size());
        //создадим новую коллекцию для проверки методов containsAll и removeAll
        Set<String> strings3 = new HashSet<String>();
        strings3.add("one");
        strings3.add("1");
        strings3.add("2");
        strings3.add("3");
        strings3.add(null);
        strings3.add("six");
        strings3.add("four");
        strings3.add("five");
        System.out.println("==============================");
        //печать коллекции для проверки containsAll и removeAll
        System.out.println("strings3: "+strings3.toString());
        //печать тестирумой коллекции
        System.out.println("objects: "+objects.toString());
        System.out.println("containsAll string3: "+objects.containsAll(strings3));
        System.out.println("removeAll string3: "+objects.removeAll(strings3));
        System.out.println("objects: "+objects.toString());
        System.out.println("size: " +objects.size());



//        System.out.println("==============================");
//        System.out.println("ListA, ListB");
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
//        System.out.println("==============================");
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
