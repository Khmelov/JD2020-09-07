package by.it.trukhanovich.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {
    public static void main(String[] args) {

        StringBuilder sb=new StringBuilder(Poem.text);
        StringBuilder sbEnd=new StringBuilder();
        Pattern patternFindMax=Pattern.compile("\\n");
        Matcher matcherFindMax=patternFindMax.matcher(sb);
        int lenghtRowMax=0;
        //найдем максимально длинную строку
        lenghtRowMax = findLenghtRowMax(matcherFindMax, lenghtRowMax);
        System.out.println("максимальная длинна строки:" + lenghtRowMax);
        String varString=sb.toString();
        String []arrayStrings=varString.split("\n");
        //заполним промежутки между словами пробелами
        sbEnd = getStringWithSpaces(sbEnd, lenghtRowMax, arrayStrings);
        System.out.print(sbEnd);
    }

    private static StringBuilder getStringWithSpaces(StringBuilder sbEnd, int lenghtRowMax, String[] arrayStrings) {
        for (int i = 0; i < arrayStrings.length; i++) {
        if (i<arrayStrings.length-1){
            if (arrayStrings[i].length() < lenghtRowMax - 1) {
                StringBuilder sbNew = new StringBuilder(arrayStrings[i]);
                if (i < arrayStrings.length - 1) sbNew = sbNew.append("\n");
                int pos = 0;
                Pattern pNew = Pattern.compile("[ ][-а-яА-Я]");
                Matcher mNew = pNew.matcher(sbNew);
                while (sbNew.length() < lenghtRowMax) {
                    pos = 0;
                    while (mNew.find(pos)) {
                        pos = mNew.end();
                        sbNew.replace(mNew.start(), mNew.end() - 1, "  ");
                        if (sbNew.length() == lenghtRowMax) break;
                    }
                }

                sbEnd = sbEnd.append(sbNew);

            } else {
                StringBuilder sbNew = new StringBuilder(arrayStrings[i]);
                sbNew = sbNew.append("\n");
                sbEnd = sbEnd.append(sbNew);}
        }
        if (i==arrayStrings.length-1){
                if (arrayStrings[i].length() < lenghtRowMax-1) {
                    StringBuilder sbNew = new StringBuilder(arrayStrings[i]);
//                    if (i < arrayStrings.length - 1) sbNew = sbNew.append("\n");
                    int pos = 0;
                    Pattern pNew = Pattern.compile("[ ][-а-яА-Я]");
                    Matcher mNew = pNew.matcher(sbNew);
                    while (sbNew.length() < lenghtRowMax-1) {
                        pos = 0;
                        while (mNew.find(pos)) {
                            pos = mNew.end();
                            sbNew.replace(mNew.start(), mNew.end() - 1, "  ");
                            if (sbNew.length() == lenghtRowMax) break;
                        }
                    }

                    sbEnd = sbEnd.append(sbNew);

                } else {
                    StringBuilder sbNew = new StringBuilder(arrayStrings[i]);
                    sbEnd = sbEnd.append(sbNew);}
            }
        }
        return sbEnd;
    }

    private static int findLenghtRowMax(Matcher m2, int lenghtRowMax) {
        int pos;
        pos=0;
        while (m2.find(pos)){
            int lenghtRow= m2.start()-pos+1;
            if (lenghtRow> lenghtRowMax) {
                lenghtRowMax =lenghtRow;}
            pos= m2.start()+1;

        }
        return lenghtRowMax;
    }
}
