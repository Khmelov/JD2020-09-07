package by.it.stefankin.jd01_06;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class TaskA1 {
    public static void main(String[] args) {
        StringBuilder sb=new StringBuilder(Poem.text);
        Pattern pat=Pattern.compile("[а-яА-ЯёЁ]{4,}");
        Matcher mat= pat.matcher(Poem.text);
        while (mat.find()) {
            int start=mat.start();
            sb.setCharAt(start+3,'#');
            if(mat.group().length()>=7) {
                sb.setCharAt(start+6,'#');
            }
        }
        System.out.println(sb);




    }


}
