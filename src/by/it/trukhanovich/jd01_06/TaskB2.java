package by.it.trukhanovich.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {
        StringBuilder sb= new StringBuilder(Poem.text);
        Pattern p1= Pattern.compile("[. ]{4}[а-я]");
        Matcher m1 = p1.matcher(sb);
        //заменим троеточие
        replace(sb, m1);
        Pattern p2= Pattern.compile("[-,:\\na-zA-Z ]{1}");
        Matcher m2 = p2.matcher(sb);
        replace1(sb, m2);
////        Pattern p3= Pattern.compile("[ ](?! )");
//        Pattern p3= Pattern.compile("[ ]{1}");
//        Matcher m3 = p3.matcher(sb);
//        while (m3.find()){
//            sb.replace(m3.start(), m3.end(), "+");
//        }

        System.out.println(sb);

    }

    private static void replace1(StringBuilder sb, Matcher matcher) {
        while (matcher.find()){
            sb.replace(matcher.start(), matcher.end(), " ");
        }
    }

    private static void replace(StringBuilder sb, Matcher m1) {
        while (m1.find()){
            int start=-1;
            int end=-1;
            start= m1.start();
            end= m1.end()-2;
            sb.replace(start, end, "Z");
        }
    }
}
