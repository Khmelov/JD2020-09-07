package by.it.trukhanovich.jd01_12;

import java.util.*;


public class TaskB2 {
    public static void main(String[] args) {
        int n=10;
        List<String> strings1 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            strings1.add(String.valueOf(i+1));
        }
        List<String> strings2 = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            strings2.add(String.valueOf(i+1));
        }
        String s1 = new String(process((ArrayList<String>) strings1));
        String s2 = new String(process((LinkedList<String>) strings2));

        System.out.println(s1);
        System.out.println(s2);
    }
    static String process(ArrayList<String> peoples) {
        ArrayList<String> strings = new ArrayList<>(peoples);
        int check=1;
        for(;strings.size()>1;){
            for (int i = 0; i < strings.size(); ) {
                if (check==1) {check=2;i++; continue;}
                if (check==2) {strings.remove(i); check=1; }
            }
        }
        String s= strings.get(0);
        return s;
    }

    static String process(LinkedList<String> peoples) {
        List<String> strings = new LinkedList<>(peoples);
        int check=1;
        for(;strings.size()>1;){
            for (int i = 0; i < strings.size(); ) {
                if (check==1) {check=2;i++; continue;}
                if (check==2) {strings.remove(i); check=1; }
            }
        }
        String s= strings.get(0);
        return s;
    }

}
