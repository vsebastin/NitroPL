package keywordsLibrary;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.MyLogger;

public class UserAction {
    private WebDriver driver;
    public UserAction(WebDriver driver ) {
        this.driver = driver;

    }

    public WebElement getElement(By locator) {
        //driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);

        WebElement webElement = driver.findElement(locator);
        return webElement;
    }

    public void input(By locator, String userData) {
        try {
            String curElementName = getElementName(locator);
            MyLogger.info("user inputs value in " + curElementName );
            WebElement webElement = getElement(locator);

            webElement.clear();
            webElement.sendKeys(userData);

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
    public void click(By locator)
    {
        String curElementName = getElementName(locator);
        MyLogger.info("user inputs value in " + curElementName );
        getElement(locator).click();
    }
    public String getElementName(By locator){
        String elementName="";
        try {
            String locString = locator.toString();
            String arrLocator[] = locString.split(":");
            elementName = arrLocator[1];

        }
        catch(Exception e){
            MyLogger.error(e.getMessage());
        }
        return elementName;

    }



}
