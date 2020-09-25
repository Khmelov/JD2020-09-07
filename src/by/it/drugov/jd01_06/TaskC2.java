package by.it.drugov.jd01_06;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TaskC2 {
    public static void main(String[] args) {
        String [] word = Poem.text.split("[^а-яА-ЯёЁ]+");
        String line = Arrays.toString(word);
        double startTime = System.nanoTime();
        line = slow(line);
        double endTime = System.nanoTime();
        System.out.printf("Текст : \n %s \n", line);
        System.out.printf("Время,затраченное на конкатенацию строки (с помощью String) : %-5.3f милисекунд\n", (endTime - startTime) / 1000000);
        line = Arrays.toString(word);
        startTime = System.nanoTime();
        line = fast(line);
        endTime = System.nanoTime();
        System.out.printf("Текст : \n %s \n", line);
        System.out.printf("Время,затраченное на конкатенацию строки (с помощью StringBuilder) : %-5.3f милисекунд\n", (endTime - startTime) / 1000000);
    }

    static String fast(String line) {
        String [] word = Poem.text.split("[^а-яА-ЯёЁ]+");
        String strLine = Arrays.toString(word);
        StringBuilder sbLine = new StringBuilder(strLine);
        while (sbLine.length() <= 100000) {
            sbLine.append(line);
        }
        line = String.valueOf(sbLine);
        return line;

    }

    static String slow(String line) {
        String [] word = Poem.text.split("[^а-яА-ЯёЁ]+");
        String strLine = Arrays.toString(word);
        while (strLine.length() <= 100000) {
            strLine = strLine.concat(line);
        }
        return strLine;
    }
}
