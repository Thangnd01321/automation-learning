package anhtester;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import selenium.core.BasePage;
import selenium.settings.Browsers;

public class LoginPage extends BasePage {
    public By inputEmail = By.xpath("//label[text()='Email']/following-sibling::input");
    public By inputPassword = By.xpath("//label[text()='Password']/following-sibling::input");
    public By btnLogin = By.xpath("//button[text()='Login']");
    public By lblErrorMessage = By.xpath("//div[@class='alert alert-danger alert-dismissable']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmail(String email) {
        System.out.println("Enter user name " + email);
        getDriver().findElement(this.inputEmail).sendKeys(email);
    }

    public void enterPassword(String password) {
        System.out.println("Enter user name " + password);
        getDriver().findElement(this.inputPassword).sendKeys(password);
    }

    public void clickLoginButton() {
        System.out.println("Click on login button");
        getDriver().findElement(this.btnLogin).click();
    }

    public String getErrorMessage() {
        System.out.println("Verify error message");
        return getDriver().findElement(this.lblErrorMessage).getText();
    }
}
