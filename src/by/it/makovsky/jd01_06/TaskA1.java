package by.it.makovsky.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args) {
        StringBuilder dynText = new StringBuilder(Poem.text);
        Pattern p = Pattern.compile("[а-яА-ЯёЁ]{4,}");
        Matcher m = p.matcher(dynText);
        while (m.find()) {
            dynText.setCharAt(m.start() + 3, '#');
            if (m.end() - m.start() >= 7) {
                dynText.setCharAt(m.start() + 6, '#');
            }
        }
        System.out.println(dynText);
    }
}
