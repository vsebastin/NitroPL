package nitroExecution;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.paulhammant.ngwebdriver.NgWebDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import util.ConfigReader;
import util.MyLogger;

public class NitroHooks {

    private DriverFactory driverFactory;
    private WebDriver driver;
    private ConfigReader configReader;
    Properties prop;
    public String scenarioName;

    @Before(order = 0)
    public void setPropertyFile(Scenario scenario) {
        System.out.println("set property executed for" + scenario.getName());
        scenarioName = scenario.getName();
        MyLogger.startTestCase(scenarioName);
        MyLogger.info(scenarioName);
        configReader = new ConfigReader();
        prop = configReader.initPropertiesFile();
    }

    @Before(order=1)
    public void launchURL() {
        //System.out.println("launch URL executed for" + scenario.getName());

        driverFactory = new DriverFactory();
        driver = driverFactory.setupDriver(prop.getProperty("browser"));
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        //NgWebDriver ngWebDriver = new NgWebDriver((JavascriptExecutor) (driver));
    }

    @After(order=0)
    public void quitBrowser(Scenario scenario) {
        System.out.println("quit browser" + scenario.getName());
        driver.quit();
    }
    @After(order=1)
    public void teardown(Scenario scenario) {

        MyLogger.endTestCase(scenario.getName());
		/*
		if (scenario.isFailed()) {
		System.out.println("teardown executed for" + scenario.getName());
		String screenshotName = scenario.getName().replace(" ", "_");
		byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(sourcePath, "image/png", screenshotName);

		//scenario.attach("C://Mashreq//NitroNew//Test.png", "img/png", "test");
		}
		*/
    }

    @AfterStep
    public void as(Scenario scenario) {
        String screenshotName = scenario.getName().replace(" ", "_");
        byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(sourcePath, "image/png", screenshotName);
    }



}
