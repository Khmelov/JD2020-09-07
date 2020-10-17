package by.it.makovsky.jd01_15;

import java.io.*;
import java.util.LinkedList;

public class TaskB {
    public static void main(String[] args) throws Exception {
        String proga=getPath(TaskB.class)+"TaskB.java";
        System.out.println(proga);
        try {
            BufferedReader inputStream = new BufferedReader(new FileReader(proga));
            LinkedList<String> str = new LinkedList<>();
            while (inputStream.ready()){
                String s=inputStream.readLine();
                str.add(s);
            }
            System.out.println(str);
        } catch (FileNotFoundException e) {
            throw new Exception(e);
        }
    }

    private static String getPath(Class<TaskB> taskBClass) {
        String rootProject = System.getProperty("user.dir");
        String relativePath = taskBClass
                .getName()
                .replace(taskBClass.getSimpleName(), "")
                .replace(".", File.separator);
        return rootProject + File.separator + "src" + File.separator + relativePath;
    }
}
