package nitroExecution;

import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

        plugin = {"json:target/cucumber-reports/cucumber.json","pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"

        },

        features = {"src/test/resources/features"},
        glue = {"nitroTests","nitroExecution"}

)

public class TestRunner extends AbstractTestNGCucumberTests{

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}

