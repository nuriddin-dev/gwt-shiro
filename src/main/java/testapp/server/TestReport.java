package testapp.server;

import testapp.server.util.JpaUtil;
import testapp.server.util.ReportUtil;

import java.io.File;

public class TestReport {

    public static void main(String[] args) {
        try {
            ReportUtil ru = new ReportUtil();
            File pdfFile = ru.toPdf(ReportUtil.REPORT_DIR + "/event/report1.jasper", null, JpaUtil.getConnection(), null);
            System.out.println(pdfFile.getPath());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
