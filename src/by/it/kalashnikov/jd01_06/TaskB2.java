package by.it.kalashnikov.jd01_06;



import java.util.regex.Matcher;
import java.util.regex.Pattern;

class TaskB2 {
    private static String reg = ",.?!-";

    private static  boolean  checkWord (String  word){
        int start = word.charAt(0);
        int end=word.charAt(word.length()-1);
        return reg.indexOf(start)<0 || reg.indexOf(end)>=0;
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(Poem.text);

        Pattern pattern = Pattern.compile("[.]{3}");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()){
            int start = matcher.start();
            sb.replace(start, start+3, "");
        }



    }
}
