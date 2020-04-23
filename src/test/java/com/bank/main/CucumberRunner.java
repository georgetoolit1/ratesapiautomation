package com.bank.main;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;

import static com.bank.utils.ReportHelper.generateTestReport;

@CucumberOptions( strict = true, monochrome = true, features = "src/test/resources/features",
        glue = "com.bank.stepdefinitions",
        plugin = {"pretty", "json:target/cucumber.json"}, tags = {"@smoke"}
)
public class CucumberRunner extends AbstractTestNGCucumberTests {
    private static Logger logger = LoggerFactory.getLogger(CucumberRunner.class);

    @AfterSuite(alwaysRun = true)
    public void generateHTMLReports() {
        logger.info("Generating Cucumber test report");
        generateTestReport();
    }
}