package by.it.hryntsaliou.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class TaskA {

    static final String FILENAME = "dataTaskA.bin";
    static final String TASK_A_TXT = "resultTaskA.txt";

    public static void main(String[] args) {
        String path = getPath(TaskA.class);
        String filename = path + FILENAME;
        writeInt(filename);
        List<Integer> list = new ArrayList<>();
        readInt(filename, list);
        consolePrint(list);
        txtPrint(path, list);
    }

    private static void txtPrint(String path, List<Integer> list) {
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

    private static void consolePrint(List<Integer> list) {
        double sum = 0;
        for (Integer integer : list) {
            System.out.printf("%d ", integer);
            sum += integer;
        }
        System.out.println("\navg=" + sum / list.size());
    }

    private static void readInt(String filename, List<Integer> list) {
        try (DataInputStream dis = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(filename)))) {
            while (dis.available() > 0) {
                list.add(dis.readInt());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeInt(String filename) {
        try (DataOutputStream dataOutputStream = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(filename)))
        ){
            for (int i = 0; i < 20; i++) {
                int value = 10 + ((int) (Math.random() * 100));
                dataOutputStream.writeInt(value);
            }

        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    private static String getPath(Class<TaskA> taskAClass) {
        String rootProject = System.getProperty("user.dir");
        String relativePath = taskAClass.getName()
                .replace(taskAClass.getSimpleName(), "")
                .replace(".", File.separator);
        return rootProject + File.separator + "src" + File.separator + relativePath;
    }
}
