package by.it.yatsevich.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {
        StringBuilder sb= new StringBuilder(Poem.text);
        Pattern pattern1= Pattern.compile("[. ]{4}[а-я]");
        Matcher matcher1 = pattern1.matcher(sb);
        replace(sb, matcher1);
        Pattern pattern2= Pattern.compile("[-,:\\na-zA-Z]");
        Matcher matcher2 = pattern2.matcher(sb);
        repNotLetter(sb, matcher2);
        Pattern pattern3= Pattern.compile("[!?]+");
        Matcher matcher3 = pattern3.matcher(sb);
        replaceEndSentence(sb, matcher3);
        Pattern pattern4= Pattern.compile("[ ]{2,}");
        Matcher matcher4 = pattern4.matcher(sb);
        replaceSeveralSpaces(sb, matcher4);
        String varString= sb.toString();
        String []arrayStrings;
        arrayStrings=varString.trim().split("[.]");
        trimSpaces(arrayStrings);
        arraySort(arrayStrings);
        printArray(arrayStrings);
    }

    private static void printArray(String[] arrayStrings) {
        for (String arrayString : arrayStrings) {
            System.out.println(arrayString);
        }
    }

    private static void trimSpaces(String[] arrayStrings) {
        for (int i = 0; i < arrayStrings.length; i++) {
            arrayStrings[i]= arrayStrings[i].trim();
        }
    }

    private static void arraySort(String[] arrayStrings) {
        int b = arrayStrings.length-1;
        String buf;
        boolean det;
        do {
            det=false;
            for (int i = 0; i < b; i++) {
                if (arrayStrings[i].length() > arrayStrings[i + 1].length()) {
                    buf = arrayStrings[i + 1];
                    arrayStrings[i + 1] = arrayStrings[i];
                    arrayStrings[i] = buf;
                    det = true;
                }
            }
            b--;
        }
        while (det);
    }


    private static void replaceSeveralSpaces(StringBuilder sb, Matcher m4) {
        int pos=0;
        while (m4.find(pos)){
            sb.replace(m4.start(), m4.end(), " ");
            pos=m4.start()+1;
        }
    }

    private static void replaceEndSentence(StringBuilder sb, Matcher m3) {
        int pos=0;
        while (m3.find(pos)){
            sb.replace(m3.start(), m3.end(), ".");
            pos= m3.start()+1;
        }
    }

    private static void repNotLetter(StringBuilder sb, Matcher matcher) {
        while (matcher.find()){
            sb.replace(matcher.start(), matcher.end(), " ");
        }
    }

    private static void replace(StringBuilder sb, Matcher m1) {
        while (m1.find()){
            int start;
            int end;
            start= m1.start();
            end= m1.end()-1;
            sb.replace(start, end, "\n");
        }
    }
}
