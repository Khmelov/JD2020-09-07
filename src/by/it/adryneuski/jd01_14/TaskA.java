package by.it.adryneuski.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
////
class TaskA {

    static final String FILENAME = "dataTaskA.bin";
    public static final String TASK_A_TXT = "resultTaskA.txt";

    public static void main(String[] args) {
        String path = getPath(TaskA.class);
        String fileName = path + FILENAME;
        writeInt(fileName);
        List<Integer> list = new ArrayList<>();
        readInteger(fileName, list);
        printToConsole(list);
        printToTxt(path, list);
    }

    private static void printToTxt(String path, List<Integer> list) {
        try (PrintWriter writer = new PrintWriter(path + TASK_A_TXT)){
            double sum2 = 0;
            for (Integer integer : list) {
                writer.printf("%d ", integer);
                sum2 += integer;
            }
            writer.println("\navg=" + sum2 / list.size());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void printToConsole(List<Integer> list) {
        double sum = 0;
        for (Integer integer : list) {
            System.out.printf("%d ", integer);
            sum += integer;
        }
        System.out.println("\navg=" + sum / list.size());
    }

    private static void readInteger(String fileName, List<Integer> list) {
        try (DataInputStream dis = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(fileName)))) {
            while (dis.available() > 0) {
                list.add(dis.readInt());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeInt(String fileName) {
        try (
                DataOutputStream dos = new DataOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream(fileName)
                        )
                )
        ) {
            //  dos.writeInt(90+89<<8+88*256*256+87*256*256*256); //one int == 4 char(en)
            for (int i = 0; i < 20; i++) {
                int value = 10 + (int) (Math.random() * 100);
                dos.writeInt(value);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getPath(Class<TaskA> taskAClass) {
        String rootProject = System.getProperty("user.dir");
        String relativePath = taskAClass
                .getName()
                .replace(taskAClass.getSimpleName(), "")
                .replace(".", File.separator);
        return rootProject + File.separator + "src" + File.separator + relativePath;
    }
}
