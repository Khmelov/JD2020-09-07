package by.it.kalashnikov.jd01_06;



import java.util.regex.Matcher;
import java.util.regex.Pattern;

class TaskB1 {
    private static final String gl = "аAеEёЁоОуУыЫэЭюЮяЯиИ";

//    Приватный метод без regex для проверки условия :
//    начинается ли слово с согласной буквы и заканчивается ли на гласную
    private static  boolean  checkWord (String word){
        int start = word.charAt(0);
        int end=word.charAt(word.length()-1);
        return gl.indexOf(start)<0 && gl.indexOf(end)>=0;
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder( Poem.text);
        Pattern pat = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pat.matcher(sb);
        while (matcher.find()){
            String word = matcher.group();
            if (checkWord(word))
            System.out.println(word);
        }
    }
}
