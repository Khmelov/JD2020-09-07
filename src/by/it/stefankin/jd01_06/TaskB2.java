package by.it.stefankin.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {
        StringBuilder sb= new StringBuilder(Poem.text);

        Pattern pat= Pattern.compile("[. ]{4}[а-я]");
        Matcher mat = pat.matcher(sb);

            while (mat.find()){
                int start=-1;
                int end=-1;
                start= mat.start();
                end= mat.end()-1;
                sb.replace(start, end, " ");
            }

        Pattern pat1= Pattern.compile("[!?]{1,}");
        Matcher mat1 = pat1.matcher(sb);
        int num=0;
        while (mat1.find(num)){
            sb.replace(mat1.start(), mat1.end(), ".");
            num= mat1.start()+1;
        }

        Pattern pat2= Pattern.compile("[-,:\\na-zA-Z]");
        Matcher mat2 = pat2.matcher(sb);

            while (mat2.find()){
                sb.replace(mat2.start(), mat2.end(), " ");
            }


        Pattern pat4= Pattern.compile("[ ]{2,}");
        Matcher mat4 = pat4.matcher(sb);

        int num1=0;
            while (mat4.find(num1)){
                sb.replace(mat4.start(), mat4.end(), " ");
                num1=mat4.start()+1;
            }

        String massiv= sb.toString();
        String[] arr;

        arr=massiv.trim().split("[\\.]");
        for (int i = 0; i < arr.length; i++) {
                arr[i]= arr[i].trim();
            }

        int b = arr.length-1;
            String rez=new String();
            boolean aa;
            do {
                aa=false;
                for (int i = 0; i < b; i++) {
                    if (arr[i].length() > arr[i + 1].length()) {
                        rez = arr[i + 1];
                        arr[i + 1] = arr[i];
                        arr[i] = rez;
                        aa = true;
                    }
                }
                b--;
            }
            while (aa);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }




    }



}













