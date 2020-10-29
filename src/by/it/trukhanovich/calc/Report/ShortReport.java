package by.it.trukhanovich.calc.Report;

import by.it.trukhanovich.calc.ConsoleRunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

public class ShortReport extends ReportBuilder {


    private final static String fileNameLog ="log.txt";


    @Override
    public void buildHeader() {

        report.setHeaderReport("Отчет о работе калькулятора (КРАТКИЙ)\nВремя начала работы: "+ ConsoleRunner.DATE_START.toString());

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

        report.setBodyReport(sbLog.toString());

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