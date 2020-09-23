package by.it.hryshanovich.jd01_06;

import by.it.hryshanovich.jd01_06.Poem;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {
        StringBuilder sb= new StringBuilder(by.it.hryshanovich.jd01_06.Poem.text);
        Pattern p1= Pattern.compile("[. ]{4}[а-я]");
        Matcher m1 = p1.matcher(sb);
        //заменим троеточие
        replace(sb, m1);
        Pattern p2= Pattern.compile("[-,:\\na-zA-Z]");
        Matcher m2 = p2.matcher(sb);
        //заменим небуквенные символы
        replaceNotLetterSymbal(sb, m2);
        Pattern p3= Pattern.compile("[!?]{1,}");
        Matcher m3 = p3.matcher(sb);
        //заменим символы конца предложения на "."
        replaceEndSentence(sb, m3);
        Pattern p4= Pattern.compile("[ ]{2,}");
        Matcher m4 = p4.matcher(sb);
        //заменим повтояриющиеся пробелы
        replaceSeveralSpaces(sb, m4);
        String varString= sb.toString();
        //создадим массив строк для преложений
        String []arrayStrings;
        arrayStrings=varString.trim().split("[\\.]");
        //обрежем пробелы в начале и конце каждого предложения
        trimSpaces(arrayStrings);
        //сортируем массив по возрастанию
        arraySort(arrayStrings);
        printArray(arrayStrings);
    }

    private static void printArray(String[] arrayStrings) {
        for (int i = 0; i < arrayStrings.length; i++) {
            System.out.println(arrayStrings[i]);
        }
    }

    private static void trimSpaces(String[] arrayStrings) {
        for (int i = 0; i < arrayStrings.length; i++) {
            arrayStrings[i]= arrayStrings[i].trim();
        }
    }

    private static void arraySort(String[] arrayStrings) {
        int b = arrayStrings.length-1;
        String buf=new String();
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

    private static void replaceNotLetterSymbal(StringBuilder sb, Matcher matcher) {
        while (matcher.find()){
            sb.replace(matcher.start(), matcher.end(), " ");
        }
    }

    private static void replace(StringBuilder sb, Matcher m1) {
        while (m1.find()) {
            int start = -1;
            int end = -1;
            start = m1.start();
            end = m1.end() - 1;
            sb.replace(start, end, "\n");
        }
    }
}
