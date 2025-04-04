package com.runner;

import com.report.CustomJVMReport;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src\\test\\resources\\"
        ,glue = "com.step",
        plugin = {"pretty", "json:target/cucumber.json"},
        tags = " @cardnumber"
)

public class TestRunner {

    @AfterClass
    public static void generateJVMReport() {
        CustomJVMReport.generateReport("target/cucumber.json");
    }


}
