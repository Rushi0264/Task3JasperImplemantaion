package com.example.jasperimplementation.service;

import com.example.jasperimplementation.entity.Employee;
import com.example.jasperimplementation.repository.EmployeeRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.HashMap;
import java.util.List;

@Service
public class ReportService {

    @Autowired
    private EmployeeRepository repository;

    public String exportPdf() throws Exception {

        List<Employee> employees = repository.findAll();

        File file = new ClassPathResource("reports/employees.jrxml").getFile();

        JasperReport jasperReport =
                JasperCompileManager.compileReport(file.getAbsolutePath());

        JRBeanCollectionDataSource dataSource =
                new JRBeanCollectionDataSource(employees);

        JasperPrint jasperPrint =
                JasperFillManager.fillReport(
                        jasperReport,
                        new HashMap<>(),
                        dataSource);

        // Create reports folder automatically
        File folder = new File("reports");
        if (!folder.exists()) {
            folder.mkdirs();
        }

        String path = "reports/employees.pdf";

        JasperExportManager.exportReportToPdfFile(
                jasperPrint,
                path);

        return "PDF Generated Successfully : " + path;
    }
}
