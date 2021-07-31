package factory;

import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import static io.github.bonigarcia.wdm.config.DriverManagerType.CHROME;

public class DriverFactory {

    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal();

    public WebDriver setupDriver(String browser) {
        DriverManagerType dmt;
        if (browser.equals("chrome")) {
            //String userDir = System.getProperty("user.dir");
            //WebDriverManager.chromedriver().properties(userDir + "\\src\\test\\resources\\webdrivermanager.properties");
            //WebDriverManager.chromedriver().config().setForceDownload(false);
            WebDriverManager.chromedriver().setup();
            tlDriver.set(new ChromeDriver());
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            tlDriver.set(new FirefoxDriver());
        } else if (browser.equals("safari")) {
            tlDriver.set(new SafariDriver());
        } else {
            System.out.println("Please pass the correct browser value: " + browser);
        }

        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        return getDriver();

    }



    public static synchronized WebDriver getDriver() {
        return tlDriver.get();
    }


}
