package anhtester;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import selenium.core.BasePage;

public class ForgotPassword extends BasePage {
    public By forgot_password = By.xpath("//*[@id=\"loginForm\"]/div[2]/span/a/b");
    public By input_Email = By.xpath("//input[@placeholder='Email']");
    public By btnClose = By.xpath("//button[text()='Close']");
    public By btnSend = By.xpath("//*[@value=\"Send\"]");

    public ForgotPassword(WebDriver driver) {
        super(driver);
    }

    public void clickForgotPassword() {
        System.out.println("Click on forgot password");
        getDriver().findElement(this.forgot_password).click();
    }

    public void enterEmail(String enterEmail) {
        System.out.println("Enter email " + enterEmail);
        getDriver().findElement(this.input_Email).sendKeys(enterEmail);

    }

    public void clickClose() {
        System.out.println("Click on close button");
        getDriver().findElement(this.btnClose).click();
    }

    public void clickSend() {
        System.out.println("Click on send button");
        getDriver().findElement(this.btnSend).click();
    }
}
