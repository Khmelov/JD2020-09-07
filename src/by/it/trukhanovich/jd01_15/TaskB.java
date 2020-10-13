package by.it.trukhanovich.jd01_15;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class TaskB {
    public static void main(String[] args) {
        String path = getPath(TaskB.class).concat(TaskB.class.getSimpleName()).concat(".java");
        System.out.println(path);
        //comment
        //comment
        /* comments
         *
         * */
        /* comments
         *
         * */
        /**
         * comment
         */
        StringBuilder sb=new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            while (br.ready()){
                sb.append(br.readLine());
                sb.append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        Pattern compile = Pattern.compile("/\\*(?s:(?!\\*/).)*\\*/");
//        Matcher m1=compile.matcher(sb);
//        int pos=0;
//        while (m1.find(pos)){
//            sb.replace(m1.start(), m1.end(), "");
//            pos=m1.start()+1;
//        }
//        Pattern compile1 = Pattern.compile("/+.+\\n");
//        Matcher m2=compile1.matcher(sb);
//        pos=0;
//        while (m2.find(pos)){
//            sb.replace(m2.start(), m2.end(), "");
//            pos=m2.start()+1;
//        }
        printToTxt(sb,getPath(TaskB.class).concat(TaskB.class.getSimpleName()).concat(".txt"));
        System.out.println(sb);

    }


    private static String getPath(Class<?> taskClass) {
        String rootProject = System.getProperty("user.dir");
        String path = taskClass.getName().
                replace(taskClass.getSimpleName(),"").
                replace(".", File.separator);
        return rootProject+File.separator+"src"+File.separator+path;
    }
    private static void printToTxt(StringBuilder sb, String path) {
        try(PrintWriter printWriter = new PrintWriter(path))
        {
            printWriter.print(sb);
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}
