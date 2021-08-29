package anhtester;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import selenium.core.BaseElement;
import selenium.core.BasePage;

public class LoginPage extends BasePage {
    private Page page;

    public LoginPage(WebDriver driver) {
        super(driver);
        page = new Page(driver);
    }

    public LoginPage enterEmail(String email) {
        System.out.println("Enter user name " + email);
        page.inputEmail().waitUntilClickable().sendKeys(email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        System.out.println("Enter user name " + password);
        page.inputPassword().waitUntilClickable().sendKeys(password);
        return this;
    }

    public LoginPage clickLoginButton() {
        System.out.println("Click on login button");
        page.btnLogin().waitUntilClickable().click();
        return this;
    }

    public String getErrorMessage() {
        System.out.println("Verify error message");
        return page.lblErrorMessage().waitUntilVisible().getText();
    }

    public class Page {
        private WebDriver driver;

        public Page(WebDriver driver) {
            this.driver = driver;
        }

        public BaseElement inputEmail() {
            return new BaseElement(driver, By.xpath("//label[text()='Email']/following-sibling::input"));
        }

        public BaseElement inputPassword() {
            return new BaseElement(driver, By.xpath("//label[text()='Password']/following-sibling::input"));
        }

        public BaseElement btnLogin() {
            return new BaseElement(driver, By.xpath("//button[text()='Login']"));
        }

        public BaseElement lblErrorMessage() {
            return new BaseElement(driver, By.xpath("//div[@class='alert alert-danger alert-dismissable']"));
        }
    }
}
