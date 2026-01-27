package cucumber.option;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(features ="C:\\Users\\prati\\Learning\\Eclipse_data\\MapAPI_Cucumber\\src\\test\\java\\Features",
plugin={"json:C:/Users/prati/Learning/Eclipse_data/MapAPI_Cucumber/target/jsonReports/cucumber-report.json"},
glue= {"StepDefinations"}) 

//

public class TestRunner {

	
		
	
	

}
