package com.automationExercise.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = { "json:target/cucumber.json",
                "html:target/defaul-html-reports.html",
                "rerun:target/rerun.txt"
        },
        features = "src/test/resources/features",
        glue = "com/automationExercise/stepDefinitions",
        dryRun = false,
        tags = "@TC16"
)
public class Runner {
}
