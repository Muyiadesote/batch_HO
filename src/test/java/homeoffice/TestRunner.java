package homeoffice;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        //this class is to run all the feature files in on go
        features = {"src/test/resources"},

        dryRun = false,
        strict = false,
        format = {"pretty", "html:target/cucumber-html-report", "json:target/report_example.json"}
)

public class TestRunner {
}

