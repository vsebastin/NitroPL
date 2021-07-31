package nitroTests.advancedAnalyticsTests;

import java.util.Map;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import nitroExecution.NitroHooks;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;


import com.paulhammant.ngwebdriver.NgWebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import keywordsLibrary.UserAction;
import nitroPages.advancedAnalyticsPage.LoginPage;
import util.ApiDataRequest;
import util.ExcelDataReader;
import util.MyLogger;

public class LoginTests {

    LoginPage loginPage = new LoginPage();
    UserAction useraction = new UserAction(DriverFactory.getDriver());
    ApiDataRequest apiDataRequest = new ApiDataRequest();
    ExcelDataReader oExcelReader = null;
    Map<String, Map<String,String>> excelData;




    @Given("user in the login page")
    public void user_in_the_login_page() {
        //SoftAssert softAssertOne = new SoftAssert();
        System.out.println("first test case");


        //curScenarioName = scenario.getName().trim();


        //MyLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
        //MyLogger.startTestCase(NitroHooks.curScenarioName);
        //MyLogger.info("login test");


        //ngWebDriver.waitForAngularRequestsToFinish();
        //ExcelDataReader oExcelReader = new ExcelDataReader("C:/Mashreq/Nitrodata.xlsx",0);
        //excelData = oExcelReader.getExcelAsMap();
        //System.out.println("scenario 1" + excelData.get("2").get("Name"));
        //apiDataRequest.sendRequest();
        //softAssertOne.assertEquals("sebastian", "sebastin");
        System.out.println("user logged in to the application - Login page");
        //softAssertOne.assertAll();


    }

    @Given("user input valid credentials")
    public void user_input_valid_credentials() {

        //SoftAssert softAssertTwo = new SoftAssert();

        System.out.println("second testcase");

        //MyLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
        MyLogger.info("input credentials test");


        System.out.println("user input the valid creadentials");
        useraction.input(loginPage.txt_login_username, "test");
        useraction.input(loginPage.txt_login_password, "test123");
        useraction.click(loginPage.btn_login);
        //softAssertTwo.assertEquals("mani", "mni");
        //softAssertTwo.assertAll();



    }



    @Then("user sucessfully login into the application")
    public void user_sucessfully_login_into_the_application() {

        System.out.println("user successfully logged in and home page is displayed");


    }

    @Given("user selects the loan menu")
    public void user_selects_the_loan_menu() {
        System.out.println("user selects the loan menu");
    }

    @Given("user in the loan home page")
    public void user_in_the_loan_home_page() {



        System.out.println(" user in the home page");

    }

    @Then("loan application page is displayed")
    public void loan_application_page_is_displayed() {
        System.out.println(" loan application page is displayed");
    }



}
