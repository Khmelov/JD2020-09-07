package by.it.stefankin.jd01_12;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        StringBuilder inp=new StringBuilder();
        for (;;) {
            String input=sc.nextLine();
            if (input.equals("end")) {
                break;
            }
            else inp.append(input+" ");
        }


        System.out.println(inp.toString());


        Pattern pat =Pattern.compile("[?.,!;:]+");
        Matcher mat= pat.matcher(inp);
        while (mat.find()){
            inp.replace(mat.start(),mat.end()," ");
        }
        Pattern pat2= Pattern.compile("[ ]{2,}");
        Matcher mat2 = pat2.matcher(inp);
        int num1=0;
        while (mat2.find(num1)){
            inp.replace(mat2.start(), mat2.end(), " ");
            num1=mat2.start()+1;
        }


        String vvedeno =inp.toString();
        vvedeno.trim();
        String[] arr=vvedeno.split(" ");
        List<String> strarr= Arrays.asList(arr.clone());
        ArrayList<String> stringa= new ArrayList<String>(strarr);
        System.out.println(stringa);
        HashSet<String> set1=new HashSet<>(stringa);
        System.out.println(set1);
        HashMap<String,Integer> set2 = new HashMap<>();
        for (String el:set1) {
            Integer num=0;
            Iterator<String> iter=stringa.iterator();
            while (iter.hasNext()){
                if (iter.next().equals(el)) num++;
            }
            set2.put(el,num);
        }
        System.out.println(set2);


    }



}
