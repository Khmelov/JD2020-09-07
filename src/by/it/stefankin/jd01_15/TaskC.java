package by.it.stefankin.jd01_15;
import java.util.*;
import java.io.File;

public class TaskC {
    public static void main(String[] args) {

        String path = getPath(TaskC.class);
        System.out.println(path);
        File file = new File(path);

        System.out.println(file.getPath());
        Scanner sc = new Scanner(System.in);
        for(;;){
            String vv =sc.nextLine();
            List<String> inp = Arrays.asList(vv.split(" "));
            File[] files = file.listFiles();
            if (inp.get(0).equals("end")){break;}
            else if (inp.get(0).equals("dir")){
               directory(path,files);
            }
            else if (inp.get(0).equals("cd")){
                path = getAddress(path, file, inp);
                file= new File(path);
            }
            else System.out.println(path);
        }

    }

    private static String getPath(Class<?> taskClass) {
        String direct = System.getProperty("user.dir");
        String path = taskClass.getName().
                replace(taskClass.getSimpleName(), "").
                replace(".", File.separator);
        return direct + File.separator + "src" + File.separator + path;
    }
    private static String getAddress(String path, File file, List<String> files) {
        if(files.get(1).equals("..")){
            path = file.getParent();
            System.out.println(path);
        }
        else {
            String newpath = path + File.separator + files.get(1);
            if (file.exists()){
                path =newpath;
                System.out.println(path);
            }
            if (!file.exists()){
                System.out.println(path);
            }
        }
        return path;
    }
    private static void directory (String path, File[] files) {
        System.out.println(" "+ path+" :");
        for (File fl : files) {
            if (!fl.isDirectory()) {
                System.out.printf("%15d %s\n",fl.length(), fl.getName());
            } else {
                System.out.printf("<DIR>           %s\n",fl.getName());
            }
        }
    }




}
