package cucumberoption;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(features ="C:\\Users\\prati\\Learning\\Eclipse_data\\Banking\\src\\test\\java\\features",
plugin={"json:C:\\Users\\prati\\Learning\\Eclipse_data\\Banking\\target\\jsonReports\\cucumber-report.json"},
glue="stepDefinations")
public class TestRunner {

	
}
