package by.it.trukhanovich.calc.Report;

import java.util.Date;

public class Report {

    private String headerReport="";
    private String bodyReport="";
    private String footerReport="";

    public void setHeaderReport(String headerReport) {
        this.headerReport = headerReport;
    }

    public void setBodyReport(String bodyReport) {
        this.bodyReport = bodyReport;
    }

    public void setFooterReport(String footerReport) {
        this.footerReport = footerReport;
    }

    @Override
    public String toString() {
        return headerReport+bodyReport+footerReport;
    }
    //    private String startReport="Отчет о работе калькулятора\n\n";
//    private String startDateDescription="Время начала работы калькулятора:\n";
//    private Date startDate;
//
//
//
//    public void setStartDate(Date startDate) {
//        this.startDate = startDate;
//    }
}
