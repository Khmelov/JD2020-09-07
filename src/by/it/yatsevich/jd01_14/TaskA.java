package by.it.yatsevich.jd01_14;

import java.io.*;
import java.util.ArrayList;

public class TaskA {

    public static final String FILE_NAME = "dataTaskA.bin";
    public static final String TASK_A_TXT = "resultTaskA.txt";

    public static void main(String[] args) {
        String path = getPath(TaskA.class);
        String fileName = path + FILE_NAME;
        writeInt(fileName);
        ArrayList<Integer> list = new ArrayList<>();
        getReadInteger(fileName, list);
        getPrintOnConsole(list);
        getPrintToFile(path, list);
    }

    private static void getPrintToFile(String path, ArrayList<Integer> list) {
        try (PrintWriter printWriter=new PrintWriter(path+TASK_A_TXT)){
            double sum=0;
            for (Integer integer : list) {
                printWriter.printf("%d ",integer);
                sum+=integer;
            }
            printWriter.println("\navg="+sum/ list.size());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void getPrintOnConsole(ArrayList<Integer> list) {
        double sum=0;
        for (Integer integer : list) {
            System.out.printf("%d ",integer);
            sum+=integer;
        }
        System.out.println("\navg="+sum/list.size());
    }

    private static void getReadInteger(String fileName, ArrayList<Integer> list) {
        try (DataInputStream dataInputStream=new DataInputStream(
                new BufferedInputStream(new FileInputStream(fileName)))){
            while (dataInputStream.available()>0){
                list.add(dataInputStream.readInt());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeInt(String fileName) {
        try (DataOutputStream dataOutputStream = new DataOutputStream(
                new BufferedOutputStream(new FileOutputStream(fileName)))) {
            for (int i = 0; i < 20; i++) {
                int value = 10 + (int) (Math.random() * 100);
                dataOutputStream.writeInt(value);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private static String getPath(Class<TaskA> taskAClass) {
        String projectDir = System.getProperty("user.dir");
        String relativePath = taskAClass.getName()
                .replace(taskAClass.getSimpleName(), "")
                .replace(".", File.separator);
        String path = projectDir + File.separator + "src" + File.separator + relativePath;
        return path;
    }
}
