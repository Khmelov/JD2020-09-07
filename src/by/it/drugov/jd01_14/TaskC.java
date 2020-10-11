package by.it.drugov.jd01_14;

import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;

public class TaskC {
    public static void main(String[] args) {
        printDir();
        printFiles();
        File fw = new File("resultTaskC.txt");
        FileWriter os = null;


    }

    private static void printFiles() {
        File file = new File(dirPackages(TaskC.class));
        File[] files = file.listFiles();
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < files.length; i++) {
            line.append(Arrays.toString(files[i].list()));
        }
        String newLine = line.toString();
        String[] lines = newLine
                .replace("[", ", ")
                .replace("]", "")
                .trim()
                .split(", ");
        for (int i = 0; i < lines.length; i++) {
            System.out.println("file:" + lines[i]);
        }
    }

    //  private static String dirFiles(Class<?> cl) {
    //  }

    private static void printDir() {
        File file = new File(dirPackages(TaskC.class));
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            String line = files[i].toString();
            System.out.println("dir:" + line.replace(files[i].getParent(), "").replace(File.separator, ""));
        }
    }

    private static String dirPackages(Class<?> cl) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String classPath = cl.getName()
                .replace(cl.getSimpleName(), "")
                .replace(".", File.separator);
        File file = new File(path + classPath);
        return file.getParent();
    }
}
