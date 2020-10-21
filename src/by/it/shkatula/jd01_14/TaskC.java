package by.it.shkatula.jd01_14;

import java.io.File;

public class TaskC {
    public static void main(String[] args) {

        String path = getPath(TaskC.class);
        System.out.println(path);
            }
    public static class ReadFilesFromFolder {
        public static File folder = new File("./by.it.shkatula.jd01_14");
        static String temp = "";

        public static void main(String[] args) {
            // TODO Auto-generated method stub
            System.out.println("Reading files under the folder "+ folder.getAbsolutePath());
            listFilesForFolder(folder);
        }

        public static void listFilesForFolder(final File folder) {

            for (final File fileEntry : folder.listFiles()) {
                if (fileEntry.isDirectory()) {
                    // System.out.println("Reading files under the folder "+folder.getAbsolutePath());
                    listFilesForFolder(fileEntry);
                } else {
                    if (fileEntry.isFile()) {
                        temp = fileEntry.getName();
                        if ((temp.substring(temp.lastIndexOf('.') + 1, temp.length()).toLowerCase()).equals("txt"))
                            System.out.println("File= " + folder.getAbsolutePath()+ "\\" + fileEntry.getName());
                    }

                }
            }
        }
    }
    private static String getPath(Class<TaskC> taskCClass) {

        String relativePath = taskCClass.getName();

        return relativePath;

    }
}
