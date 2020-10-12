package by.it.tarasevich.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskA {
    static final String FILENAME = "dataTaskA.bin";
    public static final String TASK_A_TXT = "resultTaskA.txt";

    public static void main(String[] args) {

        String path = getPath(TaskA.class);
        String fileName = path + FILENAME;
        writeInt(fileName);
        List<Integer> list = new ArrayList<>();
        readInteger(fileName, list);
        pritToConsole(list);
        printToTxt(path, list);

    }

    private static void printToTxt(String path, List<Integer> list) {
        try (PrintWriter printWriter = new PrintWriter(path + TASK_A_TXT)) {
            double sum2 = 0;
            for (Integer integer : list) {
                printWriter.printf("%d ", integer);
                sum2 = sum2 + integer;
            }
            printWriter.println("\navg=" + sum2 / list.size());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void pritToConsole(List<Integer> list) {
        double sum = 0;
        for (Integer integer : list) {
            System.out.printf("%d ", integer);
            sum += integer;
        }
        System.out.println("\n avg=" + sum / list.size());
    }

    private static void readInteger(String fileName, List<Integer> list) {
        try (DataInputStream dataInputStream = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(fileName)))) {
            while (dataInputStream.available() > 0) {
                list.add(dataInputStream.readInt());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void writeInt(String fileName) {
        try (
                DataOutputStream dataOutputStream = new DataOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream(fileName)
                        )
                )
        ) {
            for (int i = 0; i < 20; i++) {
                int value = 10 + (int) (Math.random() * 100);
                dataOutputStream.writeInt(value);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getPath(Class<TaskA> taskAClass) {
        String rootProgect = System.getProperty("user.dir");
        String relativePath = taskAClass.getName().replace(taskAClass.getSimpleName(), "")
                .replace(".", File.separator);

        return rootProgect + File.separator + "src" + File.separator + relativePath;
    }
}
