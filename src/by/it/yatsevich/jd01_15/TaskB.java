package by.it.yatsevich.jd01_15;

import java.io.*;

/**
 * Bla bla
 * Bla bla
 * Bla bla
 * Bla bla
 * Bla bla
 *
 * @author mu11er
 * @version old
 */
class TaskB {
    public static void main(String[] args) {
        //Print to console "Hello, "
        System.out.println("Hello, ");// some else
        //Print to console "Hello, world"
        String s = "world";
        System.out.println("Hello, " + s);

        /*Bla bla*/


        /*Some text
         * more text
         * and more */
        StringBuilder strB = new StringBuilder();
        String delimiter = "";
        String path = getPath() + "TaskB.java";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            while (bufferedReader.ready()) {
                String line=bufferedReader.readLine();
                line.replaceAll("(?s)/\\*.*?\\*/","");
                strB.append(line)
                        .append(delimiter)
                        .append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(strB);

        try (BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(getPath()+"TaskB.txt"))){
            bufferedWriter.append(strB);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getPath() {
        String projectDir = System.getProperty("user.dir");
        String relativePath = TaskB.class.getName()
                .replace(TaskB.class.getSimpleName(), "")
                .replace(".", File.separator);
        return projectDir + File.separator + "src" + File.separator + relativePath;
    }

}
