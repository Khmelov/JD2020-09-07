package by.it.trukhanovich.jd01_15;

import java.io.*;



public class TaskB {
    public static void main(String[] args) {
        String path = getPath(TaskB.class).concat(TaskB.class.getSimpleName()).concat(".java");
/* comments
         *
         * */
/* comments
         *
         * */
/**
         * comment
         */
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while (br.ready()) {
                sb.append(br.readLine());
                sb.append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String s = sb.toString();


        int b;
        StringBuilder test = new StringBuilder();
//многострочные коментарии
        try (final BufferedReader br = new BufferedReader(new StringReader(s))) {
            boolean m1 = false;
            boolean m2 = false;
            boolean comment = false;
            while ((b = br.read()) != -1) {
                if (comment == false) { test.append(((char) b)); }
                if (comment == false && m1 == true && b != '*') { m1 = false; continue; }
                if (comment == false && (b == '/') && (m1 == false)) { m1 = true; continue; }
                if (comment == false && (b == '*') && (m1 == true)) {
                    comment = true;
                    m1 = false;
                    test.delete(test.length() - 3, test.length()).append("\n");
                    continue;
                }
                if (comment == true && b == '*') { m2 = true;continue; }
                if (comment == true&&m2 == true && b != '/') { m2 = false; }
                if (comment == true&&m2 == true && b == '/') {comment = false;}

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String s1 = test.toString();
        StringBuilder result = new StringBuilder();
//однострочные коментарии
        try (final BufferedReader br = new BufferedReader(new StringReader(s1))) {
            boolean o1 = false;
            boolean commentO = false;
            while ((b = br.read()) != -1) {
                if (commentO == false) { result.append(((char) b)); }
                if (commentO == false&&o1 == true && b != '/') { o1 = false; continue; }
                if (commentO == false&&b == '/') {
                    if (o1 == false) { o1 = true; continue; }
                    if (o1 == true) {
                        commentO = true;
                        result.delete(result.length() - 2, result.length()).append("\n");
                    }
                }
                if (commentO == true && b == '\n') { commentO = false; }
            }
            System.out.println(result);
            printToTxt(result, getPath(TaskB.class).concat(TaskB.class.getSimpleName()).concat(".txt"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

        private static String getPath(Class<?> taskClass) {
        String rootProject = System.getProperty("user.dir");
        String path = taskClass.getName().
                replace(taskClass.getSimpleName(),"").
                replace(".", File.separator);
        return rootProject+File.separator+"src"+File.separator+path;
    }
    private static void printToTxt(StringBuilder sb, String path) {
        try(PrintWriter printWriter = new PrintWriter(path))
        {
            printWriter.print(sb);
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}
