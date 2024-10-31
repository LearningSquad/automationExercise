package com.automationTests.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "json:target/cucumber.json",
                "html:target/default-html-reports.html"
        },
        features="resources/features",
        glue="stepDefinitions",
        dryRun = true,
        tags = "@testcase"
)
public class CukesRunner {
}
