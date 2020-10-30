package by.it.trukhanovich.calc.Report;

import by.it.trukhanovich.calc.ConsoleRunner;

import java.io.*;

public class LongReport extends ReportBuilder {


    private final static String fileNameLog ="log.txt";

    private final static String fileNameErr ="log errror.txt";

    @Override
    public void buildHeader() {

        report.setHeaderReport("Отчет о работе калькулятора (ПОЛНЫЙ)\nВремя начала работы: "+ConsoleRunner.DATE_START.toString());

    }

    @Override
    public void buildBody() {
        StringBuilder sbLog=new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(getFileName(ConsoleRunner.class, fileNameLog)))){
            while (br.ready()){
                sbLog.append(br.readLine()+"\n");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        StringBuilder sbErr=new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(getFileName(ConsoleRunner.class, fileNameErr)))){
            while (br.ready()){
                sbErr.append(br.readLine()+"\n");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        report.setBodyReport(sbLog.toString()+"\nОтчет от ошибках:"+sbErr.toString());

    }

    @Override
    public void buildFooter() {

        report.setFooterReport("Время конца работы работы: "+ConsoleRunner.DATE_FINISH.toString()+"\n");
    }

    private static String getFileName(Class<?> aClass, String simpleName) {
        String rootProject = System.getProperty("user.dir");
        String path = aClass.getName().
                replace(aClass.getSimpleName(),"").
                replace(".", File.separator);
        return rootProject+File.separator+"src"+File.separator+path+simpleName;
    }
}
