package by.it.hryntsaliou.jd01_15;


import java.io.*;

/**
 * @author Nikita Hryntsaliou
 */

class TaskB {
    public static void main(String[] args) {
        String filename = getPath(TaskB.class) + "TaskB.java";
        File file = new File(filename);
        StringBuilder codeText;
        try (FileReader fileReader = new FileReader(filename)) {
            char[] chars = new char[(int) file.length()];
            fileReader.read(chars);
            codeText = new StringBuilder(String.valueOf(chars));
        } catch (IOException e) {
            throw new RuntimeException();
        }
        String path = getPath(TaskB.class) + "TaskB.txt";
        deleteSingleComment(codeText);
        deleteMultiComment(codeText);
        deleteJavaDoc(codeText);
//        System.out.println(codeText);
//        try (PrintWriter printWriter = new PrintWriter(path)) {
//            printWriter.print(codeText);
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException();
//        }
//        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
//            while (reader.ready()) {
//                System.out.println(reader.readLine());
//            }
//        } catch (IOException e) {
//            throw new RuntimeException();
//        }
    }

    private static void deleteJavaDoc(StringBuilder codeText) {
    }

    private static void deleteMultiComment(StringBuilder codeText) {
    }

    private static void deleteSingleComment(StringBuilder codeText) {
        String[] lines = codeText.toString().split("\n");
        StringBuilder newText = new StringBuilder();
        for (int i = 0; i < lines.length; i++) {
            if(!lines[i].contains("//")) {
                newText.append(lines[i]);
            }
        }
        codeText = newText;
        System.out.println(codeText);
    }

    //codeText = new StringBuilder(String.valueOf(chars))
        /*for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }*/

    //It's my code
    //I love Java


    /*Html это язык программирования,
    который объединяет людей по всему
    миру!!!
     */


    /*You've got something i need
    In this world full of people
    There's one killing me
     */
    private static String getPath(Class<TaskB> taskBClass) {
        String rootProject = System.getProperty("user.dir");
        String relativePath = taskBClass.getName()
                .replace(taskBClass.getSimpleName(), "")
                .replace(".", File.separator);
        return rootProject + File.separator + "src" + File.separator + relativePath;
    }
}
