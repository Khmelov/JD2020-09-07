package by.it.trukhanovich.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {
    private static String [] w =new String[0];
    private static int [] count=new int[0];

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(Poem.text);
        Pattern p1= Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher m1= p1.matcher(Poem.text);
        while (m1.find()){
            String word=m1.group();
            int p= position(word);
            if (p>=0) {count[p]=count[p]+1;}
            if (p==-1) {
                int last= w.length;
                w= Arrays.copyOf(w,last+1);
                count=Arrays.copyOf(count, last+1);
                w[w.length-1]=word;
                count [count.length-1]=1;
            }
        }
        for (int i = 0; i < w.length; i++) {
            System.out.printf("%s=%d", w[i], count[i]);
        }
    }
    private static int position (String word){
        for (int i = 0; i < w.length; i++) {
            if (w[i].equals(word)) return i;
        }
        return -1;
    }
}
