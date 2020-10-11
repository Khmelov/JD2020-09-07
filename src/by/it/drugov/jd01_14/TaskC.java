package by.it.drugov.jd01_14;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class TaskC {
    public static void main(String[] args) {
        StringBuilder line = new StringBuilder();
        line.append(printDir()).append(printFiles());
        File fw = new File(dir(TaskC.class) + "resultTaskC.txt");
        FileWriter os = null;
        try {
            fw.createNewFile();
            os = new FileWriter(fw);
            os.write(line.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    private static String printFiles() {
        File file = new File(dirPackages(TaskC.class));
        File[] files = file.listFiles();
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < files.length; i++) {
            line.append(Arrays.toString(files[i].list()));
        }
        String newLine = line.toString();
        line.replace(0,line.length(),"");
        String[] lines = newLine
                .replace("][", ", ")
                .replace("]", "")
                .replace("[", "")
                .split(", ");
        for (int i = 0; i < lines.length; i++) {
            lines[i]= "file:" + lines[i]+"\n";
            line.append(lines[i]);
            System.out.println(line);
        }
        return line.toString();
    }

    private static String printDir() {
        File file = new File(dirPackages(TaskC.class));
        File[] files = file.listFiles();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < files.length; i++) {
            String line = files[i].toString();
            line = line.replace(files[i].getParent(), "").
                    replace(File.separator, "");
            line = "dir:" + line + "\n";
            System.out.print(line);
            result.append(line);
        }
        return result.toString();
    }

    private static String dirPackages(Class<?> cl) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String classPath = cl.getName()
                .replace(cl.getSimpleName(), "")
                .replace(".", File.separator);
        File file = new File(path + classPath);
        return file.getParent();
    }

    private static String dir(Class<?> cl) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String classPath = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        return path + classPath;
    }
}
