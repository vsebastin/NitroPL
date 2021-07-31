package nitroTests.personaTests;

import java.util.List;
import java.util.Map;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import keywordsLibrary.UserAction;
import nitroExecution.NitroHooks;
import nitroPages.personaPages.RegistrationPage;
import org.testng.Assert;
import util.ExcelDataReader;
import util.MyLogger;

public class RegistrationTests {
    RegistrationPage registrationPage = new RegistrationPage();
    UserAction useraction = new UserAction(DriverFactory.getDriver());
    ExcelDataReader oExcelReader = null;
    Map<String, Map<String,String>> excelData;

    @Given("user in the home page")
    public void user_in_the_home_page() {


        //ExcelDataReader oExcelReader = new ExcelDataReader("C:/Mashreq/Nitrodata.xlsx",0);
        //excelData = oExcelReader.getExcelAsMap();
        //System.out.println("scenario2 " + excelData.get("3").get("address"));
        System.out.println("user logged in to the application - Registration page");

    }

    @Given("make registration")
    public void make_registration(DataTable registrationDetails) {

        System.out.println("registration page");
        List<Map<String, String>> rows = registrationDetails.asMaps(String.class, String.class);

        for(Map<String,String> columns : rows) {

            useraction.click(registrationPage.btn_Home_Register);
            useraction.input(registrationPage.CustomerFirstname, columns.get("firstName"));
            useraction.input(registrationPage.CustomerLastname, columns.get("lastName"));
            useraction.input(registrationPage.CustomerAddress, columns.get("Address"));
            useraction.input(registrationPage.CustomerCity, columns.get("city"));
            useraction.input(registrationPage.CustomerState, columns.get("state"));
            useraction.input(registrationPage.CustomerZipcode, columns.get("zipCode"));
            useraction.input(registrationPage.CustomerPhonenumber, columns.get("phone"));
            useraction.input(registrationPage.CustomerSsn, columns.get("ssn"));

            useraction.input(registrationPage.SignupUsername, columns.get("username"));
            useraction.input(registrationPage.SignupPassword, columns.get("password"));
            useraction.input(registrationPage.Repeatpassword, columns.get("confirmPassword"));
            Assert.assertEquals("false","true");
        }

    }

    @Then("verify registration is successful")
    public void verify_registration_is_successful() {
        System.out.println("payment verified");

    }


}
