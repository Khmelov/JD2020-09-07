package by.it.mialeshka.jd01_14;

import java.io.*;

public class TaskC {
    private static String dir(Class<?> clName){
        String path = System.getProperty("user.dir")+ File.separator + "src" + File.separator;
        String clDir = clName.getName().replace(clName.getSimpleName(), "").replace(".", File.separator);
        return path+clDir;
    }

    private static String getFileDir(String dir, String file){
        File dirsL = new File(dir + file +File.separator);
        StringBuilder result = new StringBuilder();
        if (dirsL.isFile()){
            result.append("file:" + file + "\n");
            return result.toString();
        }
        else{
            result.append("dir:" + file + "\n");
            String[] list = dirsL.list();
            for (int i = 0; i < list.length; i++) {
                result.append(getFileDir(dir + file + File.separator, list[i]));
            }
            return result.toString();
        }
    }


    public static void main(String[] args) {
        File dirs = new File(new File(dir(TaskC.class)).getParent());
         String[] list = dirs.list();
         try(PrintWriter out = new PrintWriter(new FileWriter(new File(dir(TaskC.class) + "resultTaskC.txt")))){
             for (int i = 0; i < list.length; i++) {
                 out.print(getFileDir(new File(dir(TaskC.class)).getParent()+File.separator,list[i]));
                 System.out.print(getFileDir(new File(dir(TaskC.class)).getParent()+File.separator,list[i]));
             }
         } catch (IOException e) {
             e.printStackTrace();
         }

    }
}
