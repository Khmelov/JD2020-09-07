package by.it.hryntsaliou.jd01_15;

import java.io.File;
import java.util.Scanner;

class TaskC {
    public static void main(String[] args) {
        String path = getPath(TaskC.class);
        Scanner scanner = new Scanner(System.in);
        File dir = new File(path);
        for (;;) {
            System.out.println(dir + ">");
            String line = scanner.nextLine();
            if (line.equals("end")) {
                break;
            }
            if (line.equals("cd ..")) {
                String parentDir = dir.getParent();
                dir = new File(parentDir);
            }
            else {
                dir = getNewDir(line, dir);
            }
            if (line.equals("dir")) {
                printDir(dir);
            }

        }

    }

    private static void printDir(File dir) {
        File[] files = dir.listFiles();
        for (int i = 0; i < files.length; i++) {
            String name = files[i].toString();
            name = name.replace((files[i].getParent() + File.separator).toString(), "");
            System.out.println(name);
        }
    }

    private static File getNewDir(String line, File dir) {
        File[] files = dir.listFiles();
        for (int i = 0; i < files.length; i++) {
            String name = files[i].toString();
            name = name.replace((files[i].getParent() + File.separator).toString(), "");
            String newName = "cd " + name;
            if(line.equals(newName)) {
                dir = new File(dir + File.separator + name);
            }
        }
        return dir;
    }

    private static String getPath(Class<TaskC> taskCClass) {
        String rootProject = System.getProperty("user.dir");
        String relativePath = taskCClass.getName()
                .replace(taskCClass.getSimpleName(), "")
                .replace(".", File.separator);
        return rootProject + File.separator + "src" + File.separator + relativePath;
    }

}
