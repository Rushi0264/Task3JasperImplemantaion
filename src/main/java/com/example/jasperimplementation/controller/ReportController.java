package com.example.jasperimplementation.controller;

import com.example.jasperimplementation.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/test")
    public String test() {
        return "Controller Working";
    }

    @GetMapping("/pdf")
    public String generatePdf() throws Exception{
        return reportService.exportPdf();
    }
}
