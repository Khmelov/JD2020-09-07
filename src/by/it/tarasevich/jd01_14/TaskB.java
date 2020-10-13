package by.it.tarasevich.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskB {
    public static final String TASK_B_TXT = "resultTaskB.txt";
    static final String FILENAME = "dataTaskB.bin";

    public static void main(String[] args) {
        String path = getPath(TaskB.class);
        String fileName = path + FILENAME;
        writeInt(fileName);
        List<Integer> list = new ArrayList<>();
        printToTxt(path,list);


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

    private static String getPath(Class<TaskB> taskBClass) {
        String rootProgect = System.getProperty("user.dir");
        String relativePath = taskBClass.getName().replace(taskBClass.getSimpleName(), "")
                .replace(".", File.separator);

        return rootProgect + File.separator + "src" + File.separator + relativePath;
    }
    private static void printToTxt(String path, List<Integer> list) {
        try (PrintWriter printWriter = new PrintWriter(path + TASK_B_TXT)) {
            double sum2 = 0;
            for (Integer integer : list) {
                printWriter.printf("%d ", integer);
                sum2 = sum2 + integer;
            }
            printWriter.println("\nwords=" + sum2 / list.size());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
