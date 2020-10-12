package by.it.yatsevich.jd01_14;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TaskB {

    public static final String TEXT_TXT = "text.txt";

    public static void main(String[] args) {
        String path = getPath();
        String fileName = path + TEXT_TXT;
        ArrayList<String> strings = new ArrayList<>();
        getRead(fileName,strings);
        System.out.println(strings);
        getMath(strings);
    }

    private static void getMath(ArrayList<String> strings) {
        StringBuffer stringBuffer=new StringBuffer();
        for (String string : strings) {
            stringBuffer.append(string);
            stringBuffer.append(' ');
        }
        Pattern pattern2 = Pattern.compile("[а-яА-ЯёЁ]+");
        Pattern pattern= Pattern.compile("[/\\s\\.—,:;?(){}!\\-]");
        Matcher matcher1= pattern2.matcher(stringBuffer);
        Matcher matcher= pattern.matcher(stringBuffer);
        int words = 0,marks = 0;
        while (matcher1.find())words++;
        while (matcher.find())marks++;

       // System.out.println(stringBuffer);
        System.out.println("words="+words+", punctuation marks="+marks);
    }

    private static void getRead(String fileName, ArrayList<String> strings) {
        try (BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8))) {
            while (bufferedReader.ready()){
                strings.add(bufferedReader.readLine());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getPath() {
        String projectDir = System.getProperty("user.dir");
        String relativePath = TaskB.class.getName()
                .replace(TaskB.class.getSimpleName(), "")
                .replace(".", File.separator);
        return projectDir + File.separator + "src" + File.separator + relativePath;
    }
}
