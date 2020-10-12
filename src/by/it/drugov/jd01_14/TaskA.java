package by.it.drugov.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskA {

    private static String dir(Class<?> cl) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String classDir = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        return path + classDir;
    }

    public static void main(String[] args) {
        DataOutputStream dos = null;
        System.out.println(dir(TaskA.class));
        try {
            dos = new DataOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(dir(TaskA.class) + "dataTaskA.bin"))
            );
            for (int i = 0; i < 20; i++) {
                dos.writeInt((int) (Math.random() * 20));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dos != null) {
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        try (DataInputStream dis = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(dir(TaskA.class) + "dataTaskA.bin"))
        );
             PrintWriter out = new PrintWriter(new FileWriter(dir(TaskA.class) + "resultTaskA.txt"))
        ) {
            double sum = 0;
            double count = 0;
            List<Integer> list = new ArrayList<>();
            while (dis.available() > 0) {
                list.add(dis.readInt());
                count++;
            }
            for (int i = 0; i < list.size(); i++) {
                sum += list.get(i);
                System.out.print(list.get(i) + " ");
                out.print(list.get(i) + " ");
            }


            System.out.println("\n avg=" + sum / count);
            out.print("\n avg=" + sum / count);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
