package by.it.trukhanovich.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskA {

    public static final String FILE_NAME = "dataTaskA.bin";
    public static final String TASK_A_TXT = "resultTaskA.txt";

    public static void main(String[] args) {
        String path=getPath(TaskA.class);
        String fileName=path+FILE_NAME;
        writeInt(fileName);
        List<Integer> list = new ArrayList<>();
        readInteger(fileName, list);
        printToConsole(list);
        printToTxt(path, list);

    }

    private static void printToConsole(List<Integer> list) {
        double sum=0;
        for (Integer integer : list) {
            System.out.printf("%d ",integer);
            sum+=integer;
        }
//        System.out.printf("\navg=%6.3f",sum/list.size());
        System.out.printf("\navg=%s",sum/ list.size());
//        System.out.println("\navg="+sum/list.size());
    }

    private static void printToTxt(String path, List<Integer> list) {
        try(PrintWriter printWriter = new PrintWriter(path +TASK_A_TXT))
        {
            double sum1=0;
            for (Integer integer : list) {
                printWriter.printf("%d ", integer);
                sum1+=integer;
            }
            printWriter.printf("\navg=%s",sum1/ list.size());

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void readInteger(String fileName, List<Integer> list) {
        try(DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(fileName))))
        {
            while (dis.available()>0){
                list.add(dis.readInt());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeInt(String fileName) {
        try (DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)));)
        {
            for (int i = 0; i < 20; i++) {
                int value = (int) (Math.random()*101);
                dos.writeInt(value);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getPath(Class<TaskA> taskAClass) {
        String rootProject = System.getProperty("user.dir");
        String path = taskAClass.getName().
                replace(taskAClass.getSimpleName(),"").
                replace(".",File.separator);
        return rootProject+File.separator+"src"+File.separator+path;
    }
}
