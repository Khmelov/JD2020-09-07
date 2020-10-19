package by.it.kalashnikov.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {

    static String addSpace(String str, int start, int countAdd){
        if(str.length() == countAdd) return str;
        Pattern pattern = Pattern.compile("[ ]{1,}");
        Matcher m = pattern.matcher(str);
        if (m.find(start)){
            int st = m.start();
            int finish = m.end() + 1;
            StringBuilder sb = new StringBuilder(str);
            sb.insert(st+1, ' ');
            str = sb.toString();
            return addSpace(str, finish, countAdd);
        }
        else {
            return addSpace(str, 0, countAdd);
        }
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[\\n]{1}");
        String[] arrStr = pattern.split(sb);

        int count = 0;
        for (int i = 0; i < arrStr.length; i++) {
            if(arrStr[i].length() > count)
                count = arrStr[i].length();
        }
        for (int i = 0; i < arrStr.length; i++) {
            arrStr[i] = addSpace(arrStr[i], 0, count);
        }
        for (int i = 0; i < arrStr.length; i++) {
            System.out.println(arrStr[i]);
        }
    }
}
