package by.it.stefankin.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    private static String dir(Class<?> cl) {
        String path = System.getProperty("user.dir")+ File.separator+"src"+File.separator;
        String cldir= cl.getName().replace(cl.getSimpleName(), "").replace(".",File.separator);
        return path+cldir;
    }

    public static void main(String[] args) throws IOException {
        StringBuilder ishodn =new StringBuilder();
        String ishstr=null;
        File f=new File(dir(TaskB.class)+"TaskB.txt");
        FileReader inp=null;
        int bb = 0;
        int countwords=0;
        int puncmrk=0;

        try {
            inp = new FileReader(f);
            while ((bb=inp.read()) !=-1) {
                ishodn.append((char)bb);
                }
            ishstr=ishodn.toString();
            //System.out.println(ishstr);
            Pattern pat1=Pattern.compile("[А-Яа-яЁё]+");
            Matcher mat1=pat1.matcher(ishstr);

            while (mat1.find()) {
                countwords++;
            }
            Pattern pat2=Pattern.compile("[-,.:!?]+");
            Matcher mat2=pat2.matcher(ishstr);

            while (mat2.find()) {
                puncmrk=puncmrk+1;
            }
            System.out.println("words="+countwords+","+"punctuation marks="+puncmrk);


        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(inp != null)
                try {
                    inp.close();
                }
            catch (IOException e) {
                    e.printStackTrace();
            }
        }
        try (PrintWriter out2= new PrintWriter(new FileWriter(dir(TaskB.class)+"resultTaskB.txt")))
            {
            out2.print("words="+countwords+","+"punctuation marks="+puncmrk);

            }
            catch (IOException e){
            e.printStackTrace();
        }


    }

}
