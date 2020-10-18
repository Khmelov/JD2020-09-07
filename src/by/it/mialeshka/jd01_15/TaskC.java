package by.it.mialeshka.jd01_15;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str;
        String dir =System.getProperty("user.dir") + File.separator + "src" + File.separator
                + TaskC.class.getName().replace(TaskC.class.getSimpleName(), "").replace(".", File.separator);
        Path path = Paths.get(dir);
        while (!(str = scanner.nextLine()).equals("end")){
            if(str.matches("cd[ ]*..")){
                path = path.getParent();
                System.out.println(path+">");
            }
            else{
                if(str.matches("cd [\\w]+")) {
                    Pattern pattern = Pattern.compile(" [\\w]+");
                    Matcher matcher = pattern.matcher(str);
                    while (matcher.find()){
                        if(Files.exists(Paths.get(path.toString()+File.separator + matcher.group().trim()))){
                            path = Paths.get(path.toString()+File.separator + matcher.group().trim());
                            System.out.println(path + ">");
                        }
                        else System.out.println("Системе не удается найти указанный путь.");
                    }
                }
                else{
                    if(str.equals("dir")){
                        try(Stream<Path> list = Files.list(path)){
                            Object[] objects = list.toArray();
                            for (Object element: objects) {
                                System.out.println(element);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
