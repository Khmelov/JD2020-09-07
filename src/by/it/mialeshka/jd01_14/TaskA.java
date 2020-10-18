package by.it.mialeshka.jd01_14;

import java.io.*;

public class TaskA {
    private static String dir(Class<?> clName){
        String path = System.getProperty("user.dir")+ File.separator + "src" + File.separator;
        String clDir = clName.getName().replace(clName.getSimpleName(), "").replace(".", File.separator);
        return path+clDir;
    }
    public static void main(String[] args) {
        DataOutputStream dos = null;
        try{
            dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(dir(TaskA.class)+"dataTaskA.bin")));
            for (int i = 0; i < 20; i++) {
                dos.writeInt((int) (Math.random()*25));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(dos != null){
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        PrintWriter out = null;
        try(DataInputStream inp = new DataInputStream(new BufferedInputStream(new FileInputStream(dir(TaskA.class)+"dataTaskA.bin")))){
            double sum = 0.0;
            double count = 0;
            out = new PrintWriter(new FileWriter(dir(TaskA.class) + "resultTaskA.txt"));
            while (inp.available() > 0){
                int i = inp.readInt();
                System.out.print(i+" ");
                sum = sum + i;
                count++;
                out.print(i + " ");
            }
            out.print("\navg="+sum/count);
            System.out.println("\navg="+sum/count);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(out != null){
                out.close();
            }
        }
    }
}
