package by.it.drugov.jd01_15;

import java.io.File;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String path = getPath(TaskC.class);
        File catalog = new File(path);
        System.out.println("Текущий каталог : " + path);
        for (; ; ) {
            System.out.print(catalog + ">");
            String command = scanner.nextLine();
            if (command.equals("end")) {
                break;
            }
            if (command.equals("cd..") || command.equals("cd ..")) {
                String parentString = catalog.getParent();
                catalog = new File(parentString);
            } else {
                catalog = getNewPath(command, catalog);
            }
            if (command.equals("dir")) {
                printDir(catalog);
            }
        }

    }

    private static void printDir(File catalog) {
        File[] files = catalog.listFiles();
        for (int i = 0; i < files.length; i++) {
            String name = files[i].toString();
            name = name.replace((files[i].getParent() + File.separator).toString(), "");
            System.out.println(name);
        }
    }

    private static File getNewPath(String command, File catalog) {
        File[] files = catalog.listFiles();
        for (int i = 0; i < files.length; i++) {
            String name = files[i].toString();
            name = name.replace((files[i].getParent() + File.separator).toString(), "");
            String tempName = "cd " + name;
            if (command.equals(tempName)) {
                catalog = new File(catalog + File.separator + name);
            }
        }
        return catalog;
    }

    private static String getPath(Class<?> cl) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String classPath = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        return path + classPath;
    }
}
