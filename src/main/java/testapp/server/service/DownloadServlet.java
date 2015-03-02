package testapp.server.service;

import net.sf.jasperreports.engine.JRException;
import testapp.server.util.JpaUtil;
import testapp.server.util.ReportUtil;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class DownloadServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String reportName = req.getParameter("report");
        String type = req.getParameter("type");

        int BUFFER = 1024 * 100;
        resp.setContentType("application/octet-stream");
        resp.setHeader("Content-Disposition:", "attachment;filename=" + "\"" + reportName + "." + type + "\"");
        OutputStream outputStream = resp.getOutputStream();
        File resultFile = getFile(reportName);
        resp.setContentLength(Long.valueOf(resultFile.length()).intValue());
        resp.setBufferSize(BUFFER);

        FileInputStream inputStream = new FileInputStream(resultFile);
        int bytesRead = -1;

        byte[] buffer = new byte[4096];
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }

        inputStream.close();
        outputStream.close();

    }

    private File getFile(String reportName) throws IOException {
        try {
            String sourceFile = ReportUtil.REPORT_DIR + "/" + reportName + ".jasper";
            ReportUtil ru = new ReportUtil();
            return ru.toPdf(sourceFile, null, JpaUtil.getConnection(), null);
        } catch (JRException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

}
