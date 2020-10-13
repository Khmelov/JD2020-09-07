package by.it.trukhanovich.jd01_15;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        String path = getPath(TaskC.class);
        File file = new File(path);
        System.out.println(file.getPath());
        for(;;){
            Scanner sc = new Scanner(System.in);
            String exception =sc.nextLine();
            List<String> strings = Arrays.asList(exception.split(" "));
            File[] files = file.listFiles();
            if (strings.get(0).equals("end")){break;}
            else if (strings.get(0).equals("dir")){
                System.out.println("содержимое "+file.getName());
                for (File f1 : files) {
                    if (f1.isDirectory()){
                        System.out.println("DIR: "+f1.getName());;
                    }
                    else System.out.println("FILE: "+f1.getName());
                }
            }
            else if (strings.get(0).equals("cd")){
                    if(strings.get(1).equals("..")){
                        path=file.getParent();
                        file= new File(path);
//                        System.out.println(path);
                    }
                    else {
                        String path1 = path + File.separator + strings.get(1);
                        file= new File(path1);
                        if (file.exists()){
                            path=path1;
//                            System.out.println(path);
                        }
                        if (!file.exists()){
                            file= new File(path);
//                            System.out.println(path);
                        }
                    }
            }
            else System.out.println(path);
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
