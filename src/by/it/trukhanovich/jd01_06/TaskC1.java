package by.it.trukhanovich.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("У     лукоморья     дуб     зелёный,\n");
        Pattern p=Pattern.compile("\\n");
        Matcher m=p.matcher(sb);
        System.out.println( "Длинна строки:"+ sb.length());

        while (m.find()){
            System.out.println("Позиция конца:" + m.start());
        }

        System.out.println(sb);
        Pattern p1=Pattern.compile("[\\s]{2,}");
        Matcher m1=p1.matcher(sb);
        int pos=0;
        while (m1.find(pos)){
            sb.replace(m1.start(), m1.end(), " ");
            pos= m1.start();
        }
        System.out.println("Длинна строки:" +sb.length());
        System.out.println(sb);
        StringBuilder sb1 = new StringBuilder(Poem.text);
        Pattern p2=Pattern.compile("\\n");
        Matcher m2=p2.matcher(sb1);
        int lenghtRowMax=0;
        pos=0;
        while (m2.find(pos)){
            int lenghtRow=m2.start()-pos+1;
            if (lenghtRow>lenghtRowMax) {lenghtRowMax=lenghtRow;}
            pos= m2.start()+1;

        }
        System.out.println("максимальная длинна строки:" + lenghtRowMax);



    }
}
