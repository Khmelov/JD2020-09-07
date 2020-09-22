package by.it.drugov.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.text);
        Pattern p1 = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher m1 = p1.matcher(text);
        while (m1.find()) {
            String word = m1.group();
            if (check(word)) {
                System.out.println(word);
            }
        }
    }

    private static boolean check(String word) {
        char[] lettersA = {'у','е','а','ё','ы','о','и','ю','я','э'};
        char[] lettersB = {'Й','Ц','К','Н','Г','Ш','Щ','З','Х','Ф','В','П','Р','Л','Д','Ж','Ч','С','М','Т','Б',
        'й','ц','к','н','г','ш','щ','з','х','ф','в','п','р','л','д','ж','ч','с','м','т','б'};
        char[] array = word.toCharArray();
        for (char letter : lettersB) {
            if (array[0] == letter) {
                for (char letter2 : lettersA) {
                    if (array[array.length - 1] == letter2) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
