package nitroPages.personaPages;

import org.openqa.selenium.By;

public class RegistrationPage {

    public By btn_Home_Register = By.xpath("//*[contains(text(),'Register')]");
    public By CustomerFirstname = By.id("customer.firstName");
    public By CustomerLastname = By.id("customer.lastName");
    public By CustomerAddress = By.id("customer.address.street");
    public By CustomerCity = By.id("customer.address.city");
    public By CustomerState = By.id("customer.address.state");
    public By CustomerZipcode = By.id("customer.address.zipCode");
    public By CustomerPhonenumber = By.id("customer.phoneNumber");
    public By CustomerSsn = By.id("customer.ssn");

    public By SignupUsername = By.id("customer.username");
    public By SignupPassword = By.id("customer.password");
    public By Repeatpassword = By.id("repeatedPassword");
    public By btnRegister = By.id("submit");

}
