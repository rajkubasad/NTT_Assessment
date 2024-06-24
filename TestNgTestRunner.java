package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "\\src\\test\\cucumber", glue = "StepDefination", monochrome = true, 
 plugin = {"html:target/cucuber.html"})
public class TestNgTestRunner extends AbstractTestNGCucumberTests{

}
