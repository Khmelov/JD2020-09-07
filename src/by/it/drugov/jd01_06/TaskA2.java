package by.it.drugov.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {
    static String[] words = {};
    static int[] amount = {};

    public static void main(String[] args) {
        StringBuilder dynText = new StringBuilder(Poem.text);
        Pattern p1 = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher m1 = p1.matcher(dynText);
        while (m1.find()) {
            setArray(m1.group());
        }
        for (int i = 0; i < words.length; i++) {
            System.out.printf("%s=%d\n", words[i], amount[i]);
        }
    }

    static void setArray(String line) {
        for (int i = 0; i < words.length; i++) {
            if (line.equals(words[i])) {
                amount[i]++;
                return;
            }
        }
        words = Arrays.copyOf(words, words.length + 1);
        amount = Arrays.copyOf(amount, amount.length + 1);
        words[words.length - 1] = line;
        amount[amount.length - 1] = 1;


    }
}
