package anhtester;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.core.BasePage;

public class ForgotPassword extends BasePage {
    public By forgot_password = By.xpath("//*[@id=\"loginForm\"]/div[2]/span/a/b");
    public By input_Email = By.xpath("//div[@class='modal-header' and ./h3[normalize-space()='Password Recovery']]/following-sibling::div[@class='modal-body']//input[@placeholder='Email']");
    public By btnClose = By.xpath("//div[@class='modal-header' and ./h3[normalize-space()='Password Recovery']]/following-sibling::div[@class='modal-body']//button[text()='Close']");
    public By btnSend = By.xpath("//div[@class='modal-header' and ./h3[normalize-space()='Password Recovery']]/following-sibling::div[@class='modal-footer']//input[@value='Send']");
    WebDriverWait wait;

    public ForgotPassword(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 20);
    }

    public void clickForgotPassword() {
        System.out.println("Click on forgot password");
        getDriver().findElement(this.forgot_password).click();
    }

    public void enterEmail(String enterEmail) {
        System.out.println("Enter email " + enterEmail);
        wait.until(ExpectedConditions.elementToBeClickable(this.input_Email)).sendKeys(enterEmail);
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
