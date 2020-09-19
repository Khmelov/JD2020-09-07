package by.it.akhmelev.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args) {
        StringBuilder dynText = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]{4,}");
        Matcher matcher = pattern.matcher(dynText);
        while (matcher.find()) {
            dynText.setCharAt(matcher.start() + 3, '#');
            if (matcher.end() - matcher.start() >= 7) {
                dynText.setCharAt(matcher.start() + 6, '#');
            }
        }
        System.out.println(dynText);
    }
}
