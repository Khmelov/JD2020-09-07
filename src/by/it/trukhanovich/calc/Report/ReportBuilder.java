package by.it.trukhanovich.calc.Report;

import java.util.Date;

abstract class ReportBuilder {

    Report report;

    public Report getReport() {
        return report;
    }
    void createNewReportProduct(){
        report=new Report();
    }

    public abstract void buildHeader();
    public abstract void buildBody();
    public abstract void buildFooter();
//    public abstract void setDateStart(Date dateStart);
//    public abstract void setDateFinish(Date dateFinish);


}
