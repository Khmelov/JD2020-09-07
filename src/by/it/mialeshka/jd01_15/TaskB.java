package by.it.mialeshka.jd01_15;

import java.io.*;

public class TaskB {
//Однострочный1
private static String dir (Class<?> className){
        return System.getProperty("user.dir") + File.separator + "src" + File.separator
                + className.getName().replace(className.getSimpleName(), "").replace(".", File.separator);
    }

    private static void DellComments( StringBuilder clearStr, String pathFile){
        boolean isWStr = false;
        boolean isMStr = false;
        try(PrintWriter addInFile = new PrintWriter(new FileWriter(pathFile))){
            for (int i = 0; i < clearStr.length(); i++) {
                char charRite = clearStr.charAt(i);
                if(i+1 < clearStr.length() && charRite == '/' && clearStr.charAt(i+1) == '/') isWStr = true;
                if(i+1 < clearStr.length() && charRite == '/' && clearStr.charAt(i+1) == '*')
                    isMStr = true;

                if(!isWStr && !isMStr){
                    addInFile.print(charRite);
                    System.out.print(charRite);
                }

                if(isWStr && charRite=='\n') {
                    isWStr = false;
                    addInFile.println();
                    System.out.println();
                }
                if(i-1 >= 0 && isMStr && charRite == '/' && clearStr.charAt(i-1) == '*') {
                    isMStr = false;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    /*Многострочный
     строка 1*/
    public static void main(String[] args) {
        /**
         * @author mialeshka
         */
        StringBuilder strTaskB = new StringBuilder();
        String str;
        String strD = "";
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(dir(TaskB.class) + File.separator + TaskB.class.getSimpleName() + ".java")))){
            while ((str = bufferedReader.readLine()) != null) {
                strTaskB.append(strD).append(str);
                strD = "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*Многострочный
         * строка 2*/
        DellComments(strTaskB, dir(TaskB.class) + File.separator + TaskB.class.getSimpleName() + ".txt");
    }
}
//Однострочный2