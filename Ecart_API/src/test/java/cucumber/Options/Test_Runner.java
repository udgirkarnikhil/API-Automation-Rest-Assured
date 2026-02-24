package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\prati\\Learning\\Eclipse_data\\Ecart_API\\src\\test\\resources\\features\\EcartFeature.feature",glue="stepDefinations",plugin = {
	    "pretty",
	    "json:C:\\Users\\prati\\Learning\\Eclipse_data\\Ecart_API\\target\\jsonReports\\cucumber.json",
	    "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
	})

public class Test_Runner {
	
	

}
