package com.sidgupta;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@results/failed_scenarios.txt",
        glue = "com.sidgupta.bdd",
        plugin = {
                "pretty",
                "html:results/rerun-results.html"
        }
)
public class RerunFailedTestsCucumberRunnerTest {

}
