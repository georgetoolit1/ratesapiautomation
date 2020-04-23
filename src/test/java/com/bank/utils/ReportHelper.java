package com.bank.utils;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ReportHelper {

    // configure cucumber report properties
    public static void generateTestReport() {
        File reportOutputDriectory = new File("target");

        List<String> jsonFiles = new ArrayList<>();
        jsonFiles.add("target/cucumber.json");

        String projectName ="RATES API TEST AUTOMATION";
        Configuration configuration = new Configuration(reportOutputDriectory, projectName);
        configuration.addClassifications("Platform", System.getProperty("os.name"));
        configuration.addClassifications("BRANCH", "RELEASE");
        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        reportBuilder.generateReports();
    }
}