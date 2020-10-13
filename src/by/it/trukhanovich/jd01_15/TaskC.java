package by.it.trukhanovich.jd01_15;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        String path = getPath(TaskC.class);
        File file = new File(path);
        System.out.println(file.getPath());
        Scanner sc = new Scanner(System.in);
        for(;;){
            String exp =sc.nextLine();
            List<String> strings = Arrays.asList(exp.split(" "));
            File[] files = file.listFiles();
            if (strings.get(0).equals("end")){break;}
            else if (strings.get(0).equals("dir")){
                getDir(path, files);
            }
            else if (strings.get(0).equals("cd")){
                path = getAddress(path, file, strings);
                file= new File(path);
            }
            else System.out.println(path);
        }

    }

    private static String getAddress(String path, File file, List<String> strings) {
        if(strings.get(1).equals("..")){
            path = file.getParent();
            System.out.println(path);
        }
        else {
            String path1 = path + File.separator + strings.get(1);
            if (file.exists()){
                path =path1;
                System.out.println(path);
            }
            if (!file.exists()){
                System.out.println(path);
            }
        }
        return path;
    }

    private static void getDir(String path, File[] files) {
        System.out.println("содержимое "+ path);
        for (File f1 : files) {
            if (f1.isDirectory()){
                Date date= new Date(f1.lastModified());
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
                System.out.print(simpleDateFormat.format(date)+"\t\t");
                System.out.printf("<DIR>           %s\n",f1.getName());
            }
            else {
                Date date= new Date(f1.lastModified());
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
                System.out.print(simpleDateFormat.format(date)+"\t\t");
                System.out.printf("%15d %s\n",f1.length(), f1.getName());
            }
        }
    }

    private static String getPath(Class<?> taskClass) {
        String rootProject = System.getProperty("user.dir");
        String path = taskClass.getName().
                replace(taskClass.getSimpleName(), "").
                replace(".", File.separator);
        return rootProject + File.separator + "src" + File.separator + path;
    }
}
