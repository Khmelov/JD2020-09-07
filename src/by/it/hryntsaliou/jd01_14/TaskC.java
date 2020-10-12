package by.it.hryntsaliou.jd01_14;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

class TaskC {
    static final String TASK_C_TXT = "resultTaskC.txt";

    public static void main(String[] args) {
        String projectLocation = getProjectLocation(TaskC.class);
        String path = getPath(TaskC.class) + TASK_C_TXT;
        System.out.println(path);
        ArrayList<String> arrayList = new ArrayList<>();
        File file = new File(projectLocation);
        File[] files = file.listFiles();
        getDir(arrayList, files);
        txtPrint(arrayList, path);
        for (String s : arrayList) {
            System.out.printf("%s \n", s);
        }
    }

    private static void txtPrint(ArrayList<String> arrayList, String path) {
        try (PrintWriter writer = new PrintWriter(path)) {
            for (String s : arrayList) {
                writer.printf("%s: ", s);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void getDir(ArrayList<String> arrayList, File[] files) {
        for (File file : files) {
            if (file.isFile()) {
                arrayList.add("file:" + file.getName());
            }
            if (file.isDirectory()) {
                arrayList.add("dir:" + file.getName());
                getDir(arrayList, file.listFiles());
            }
        }
    }

    private static String getPath(Class<TaskC> taskCClass) {
        String rootProject = System.getProperty("user.dir");
        String relativePath = taskCClass.getName()
                .replace(taskCClass.getSimpleName(), "")
                .replace(".", File.separator);
        return rootProject + File.separator + "src" + File.separator + relativePath;
    }

    private static String getProjectLocation(Class<TaskC> taskCClass) {
        String rootProject = System.getProperty("user.dir");
        String relativePath = taskCClass.getName()
                .replace(taskCClass.getSimpleName(), "")
                .replace(".", File.separator);
        return rootProject + File.separator + "src" + File.separator +
                "by" + File.separator +
                "it" + File.separator +
                "hryntsaliou";
    }
}
