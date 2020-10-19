package by.it.kalashnikov.jd01_06;



import java.util.regex.Matcher;
import java.util.regex.Pattern;

class TaskB2 {
    private static final String reg = ",.?!-";

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

        Pattern pattern1 = Pattern.compile("[!.?]");
        String[] arrString = pattern1.split(sb);
        for (int i = 0; i < arrString.length; i++) {
            arrString[i]=arrString[i].replaceAll("[^а-яА-яёЁ]"," ");
            arrString[i] = arrString[i].replaceAll("[ ]{2,}", " ");
            arrString[i] = arrString[i].trim();
        }
        for (int i = arrString.length-1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if(arrString[j].length() > arrString[j+1].length()){
                    String val = arrString[j];
                    arrString[j] = arrString[j+1];
                    arrString[j+1] = val;
                }
            }
        }
        for (String s : arrString) {
            System.out.println(s);
        }
    }
}
