package anhtester.steps;

import anhtester.LoginPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import factory.DataContainer;
import org.openqa.selenium.WebDriver;

public class LoginSteps {
    LoginPage page;

    public LoginSteps(DataContainer data){
        WebDriver driver = data.page.getDriver();
        page = new LoginPage(driver);
    }

    @When("User enter email: {string}")
    public void enterEmail(String email){
        page.enterEmail(email);
    }

    @And("User enter password: {string}")
    public void userEnterPassword(String password) {
        page.enterPassword(password);
    }

    @And("User click on login button")
    public void userClickOnLoginButton() {
        page.clickLoginButton();
    }
}
