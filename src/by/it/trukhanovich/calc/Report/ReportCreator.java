package by.it.trukhanovich.calc.Report;

import java.util.Date;

public class ReportCreator {
    private ReportBuilder reportBuilder;


    public void setReportBuilder(ReportBuilder reportBuilder) {
        this.reportBuilder = reportBuilder;
    }
    Report report() {
        return reportBuilder.getReport();
    }

    Report getReport(){
        return reportBuilder.getReport();
    }

    void constructReport(){
        reportBuilder.createNewReportProduct();
//        reportBuilder.setDateStart(new Date());
        reportBuilder.buildHeader();
        reportBuilder.buildBody();
//        reportBuilder.setDateFinish(new Date());
        reportBuilder.buildFooter();
    }


}
