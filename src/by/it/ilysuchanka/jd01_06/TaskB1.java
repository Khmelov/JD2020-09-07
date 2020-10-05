package by.it.ilysuchanka.jd01_06;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

 class TaskB1 {

    private static final String G = "АаиИУуЕеэЭОоЮюЯя";

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {
            String word = matcher.group();
            if (checkWord(word)) {
                System.out.println(word);
            }

        }
    }

    private static boolean checkWord(String word) {
        return G.indexOf(word.charAt(0)) < 0 && G.indexOf(word.charAt(word.length() - 1)) >= 0;
    }


}