package Runner;


import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\Suresh\\eclipse-workspace\\RestAssuredFramework\\src\\test\\java\\Features\\GetBook.feature",
plugin= {"json:target/JsonReports/Report.json","html:target/htmlReports","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
glue={"StepDefinitions"},tags= {" @Get_Book or @Create_Publisher or @Create_Author or @Create_Customer"})
//format={"pretty","html:test-output"})
public class TestRunner {

}