package by.it.hryntsaliou.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class TaskB2 {
    public static void main(String[] args) {
        String text = Poem.text;
        Pattern pattern = Pattern.compile("[\\n]");
        Matcher matcher = pattern.matcher(text);
        while(matcher.find()) {
            text = matcher.replaceAll(" ");
        }
        Pattern pattern3 = Pattern.compile("[. ]{4}[а-я]");
        Matcher matcher3 = pattern3.matcher(text);
        while (matcher3.find()) {
            text = matcher3.replaceAll("");
        }
        String[] lines = text.split("[\\.]");
        Pattern pattern1 = Pattern.compile("[\\p{Punct}]");
        for (int i = 0; i < lines.length; i++) {
            Matcher matcher1 = pattern1.matcher(lines[i]);
            while (matcher1.find()) {
                for (int j = 0; j < lines.length; j++) {
                    lines[i] = matcher1.replaceAll(" ");
                }
            }
        }

        Pattern pattern2 = Pattern.compile(" {2,}");
        for (int i = 0; i < lines.length; i++) {
            Matcher matcher2 = pattern2.matcher(lines[i]);
            while (matcher2.find()) {
                for (int j = 0; j < lines.length; j++) {
                    lines[i] = matcher2.replaceAll(" ");
                }
            }
        }

        int b = lines.length-1;
        String buf=new String();
        boolean det;
        do {
            det=false;
            for (int i = 0; i < b; i++) {
                if (lines[i].length()>0 && lines[i].length() > lines[i + 1].length()) {
                    buf = lines[i + 1];
                    lines[i + 1] = lines[i];
                    lines[i] = buf;
                    det = true;
                }
            }
            b--;
        }
        while (det);

        for (int i = 0; i < lines.length; i++) {
            System.out.println(lines[i].trim());

        }
    }
}
