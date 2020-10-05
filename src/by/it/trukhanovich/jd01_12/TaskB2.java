package by.it.trukhanovich.jd01_12;

import java.util.*;


public class TaskB2 {
    public static void main(String[] args) {
        int n=9;
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            strings.add(String.valueOf(i+1));
        }
        String s = new String(process((ArrayList<String>) strings));
        System.out.println(s);

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

}
