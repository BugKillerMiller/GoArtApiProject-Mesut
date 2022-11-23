package goart.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * This class is an entry point for test suite from where the test case will be initiated to run.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json"},
        features = "src/test/resources/features",
        glue = "goart/steps",
        tags = "@chosen"
)
public class CukesRunner {

}
