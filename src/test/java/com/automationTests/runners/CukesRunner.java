package com.automationTests.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "json:target/cucumber.json",
                "html:target/cucumber-reports.html",
                "junit:target/cucumber.xml"
        },
        features="resources/features",
        glue="stepDefinitions",
        dryRun = true,
        tags = "@login"
)
public class CukesRunner {
}
