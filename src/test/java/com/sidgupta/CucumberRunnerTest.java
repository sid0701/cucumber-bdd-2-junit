package com.sidgupta;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        glue = "com.sidgupta.bdd",
//        dryRun = true,
        tags = "@PlaceOrder or @OffersPage",
        plugin = {
                "pretty",
                "html:results/report.html",
                "rerun:results/failed_scenarios.txt"
        }
)
public class CucumberRunnerTest {

}
