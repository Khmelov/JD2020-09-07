package by.it.kulik.jd01_14;

import java.io.*;

public class TaskB {
    public static void main(String[] args) {
        String src = System.getProperty("user.dir") + "/src/by/it/kulik/";
        String filename = src + "JD01_14/text.txt";
        File f = new File(filename);
        FileReader is = null;
        int b, count = 0;
        try {
            is = new FileReader(f);
            while ((b = is.read()) != -1) {
                System.out.print((char) b);
                count++;
            }
            System.out.println("\n Число байт=" + count);
            System.out.println(" Кодировка " + is.getEncoding());
        } catch (IOException e) {
            System.err.println(" Ошибка файла:" + e);
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                System.err.println("ошибка закрытия:" + e);
            }
        }
    }
}