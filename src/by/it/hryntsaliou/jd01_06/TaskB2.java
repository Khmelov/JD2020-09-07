package by.it.hryntsaliou.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class TaskB2 {
    public static void main(String[] args) {
        String text = Poem.text;
        text = deleteShifts(text);
        text = delete2points(text);
        String[] lines = getStrings(text);
        spacesDeletion(lines);
        linesSort(lines);
        for (String line : lines) {
            System.out.println(line.trim());
        }
    }

    private static String deleteShifts(String text) {
        Pattern pattern = Pattern.compile("[\\n]");
        Matcher matcher = pattern.matcher(text);
        while(matcher.find()) {
            text = matcher.replaceAll(" ");
        }
        return text;
    }

    private static String delete2points(String text) {
        Pattern pattern = Pattern.compile("[. ]{4}[а-я]");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            text = matcher.replaceAll("");
        }
        return text;
    }

    private static String[] getStrings(String text) {
        String[] lines = text.split("[.]");
        Pattern pattern = Pattern.compile("[\\p{Punct}]");
        for (int i = 0; i < lines.length; i++) {
            Matcher matcher = pattern.matcher(lines[i]);
            while (matcher.find()) {
                for (int j = 0; j < lines.length; j++) {
                    lines[i] = matcher.replaceAll(" ");
                }
            }
        }
        return lines;
    }

    private static void linesSort(String[] lines) {
        int length = lines.length-1;
        String line;
        boolean ok;
        do {
            ok=false;
            for (int i = 0; i < length; i++) {
                if (lines[i].length()>0 && lines[i].length() > lines[i + 1].length()) {
                    line = lines[i + 1];
                    lines[i + 1] = lines[i];
                    lines[i] = line;
                    ok = true;
                }
            }
            length--;
        }
        while (ok);
    }

    private static void spacesDeletion(String[] lines) {
        Pattern pattern = Pattern.compile(" {2,}");
        for (int i = 0; i < lines.length; i++) {
            Matcher matcher = pattern.matcher(lines[i]);
            while (matcher.find()) {
                for (int j = 0; j < lines.length; j++) {
                    lines[i] = matcher.replaceAll(" ");
                }
            }
        }
    }
}
