package testapp.server.util;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.util.Map;

public class ReportUtil {
    /*public static final String REPORT_DIR = "src/main/resources/reports";*/
    public static final String REPORT_DIR = "reports";

    private JasperPrint fill(String sourceFileName, Map<String, Object> params, Connection connection) throws JRException {
        ClassLoader classLoader = getClass().getClassLoader();
        sourceFileName = classLoader.getResource(sourceFileName).getFile();
        if (connection == null)
            return JasperFillManager.fillReport(sourceFileName, params, new JREmptyDataSource());
        else
            return JasperFillManager.fillReport(sourceFileName, params, connection);
    }

    public File toPdf(String sourceFileName, Map<String, Object> params, Connection connection, String targetFileName) throws JRException, IOException {
        JasperPrint jasperPrint = fill(sourceFileName, params, connection);

        File resultFile;
        if (targetFileName != null && !targetFileName.isEmpty())
            resultFile = new File(targetFileName);
        else
            resultFile = Files.createTempFile("report_", ".pdf").toFile();

        JRPdfExporter exporter = new JRPdfExporter();
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(resultFile));
        SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
        configuration.setCreatingBatchModeBookmarks(true);
        exporter.setConfiguration(configuration);

        exporter.exportReport();

        return resultFile;
    }
}
