package cucumber.options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\prati\\Learning\\Eclipse_data\\FakestoreAPI\\src\\test\\java\\features",
glue="stepDefinations" , tags="@users")
public class TestRunner {


}
