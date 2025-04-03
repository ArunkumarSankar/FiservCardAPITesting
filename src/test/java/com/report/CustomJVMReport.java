package com.report;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CustomJVMReport {

    public static void generateReport(String jsonPath) {
        File reportOutputDirectory = new File("target/JVMReports");

        Configuration config = new Configuration(reportOutputDirectory, "Verification Search API");
        config.addClassifications("Environment", "QA");
        config.addClassifications("Browser", "Chrome");
        config.addClassifications("Module", "API Testing");
        config.addClassifications("Tested By", "ArunkumarSankar");

        List<String> jsonFiles = new ArrayList<>();
        jsonFiles.add(jsonPath);

        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, config);
        reportBuilder.generateReports();
    }
}
