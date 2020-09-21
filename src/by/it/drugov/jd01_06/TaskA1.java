package by.it.drugov.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class TaskA1 {
    public static void main(String[] args) {
        StringBuilder dynText = new StringBuilder(Poem.text);
        Pattern p1 = Pattern.compile("[а-яА-ЯёЁ]{4,}+");
        Matcher m1 = p1.matcher(dynText);
        while (m1.find()) {
            int start = m1.start();
            dynText.setCharAt(start + 3, '#');
            if (m1.end() - m1.start() >= 7) {
                dynText.setCharAt(start + 6, '#');
            }
        }
        System.out.println(dynText);
    }

}
