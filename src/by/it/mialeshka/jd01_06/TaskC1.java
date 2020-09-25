package by.it.mialeshka.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {

    static String addSpace(String str, int startSymbol, int countAdd){
        if(str.length() == countAdd) return str;
        Pattern pattern = Pattern.compile("[ ]{1,}");
        Matcher m = pattern.matcher(str);
        if (m.find(startSymbol)){
            int start = m.start();
            int finish = m.end() + 1;
            StringBuilder strB = new StringBuilder(str);
            strB.insert(start+1, ' ');
            str = strB.toString();
            return addSpace(str, finish, countAdd);
        }
        else {
            return addSpace(str, 0, countAdd);
        }
        }

    public static void main(String[] args) {
        StringBuilder str = new StringBuilder(Poem.text);
        Pattern paternArr = Pattern.compile("[\\n]{1}");
        String[] arrStr = paternArr.split(str);

        int maxCount = 0;
        for (int i = 0; i < arrStr.length; i++) {

            if(arrStr[i].length() > maxCount) maxCount = arrStr[i].length();
        }

        for (int i = 0; i < arrStr.length; i++) {
            arrStr[i] = addSpace(arrStr[i], 0, maxCount);
        }

        for (int i = 0; i < arrStr.length; i++) {
            System.out.println(arrStr[i]);
        }
    }
}
