package anhtester;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import selenium.core.BaseElement;
import selenium.core.BasePage;

public class ForgotPassword extends BasePage {

    private Page page;

    public ForgotPassword(WebDriver driver) {
        super(driver);
        page = new Page(driver);
    }

    public ForgotPassword clickForgotPassword() {
        System.out.println("Click on forgot password");
        page.clickForgotPassword().waitUntilClickable().click();
        return this;
    }

    public ForgotPassword enterEmail_forgotPassword(String email) {
        System.out.println("Enter email forgot password " + email);
        page.inputEmail_forgotPassword().waitUntilClickable().sendKeys(email);
        return this;
    }

    public ForgotPassword clickClose() {
        System.out.println("click on close button");
        page.btnClose().waitUntilClickable().click();
        return this;
    }

    public ForgotPassword clickSend() {
        System.out.println("Click on Send button");
        page.btnSend().waitUntilClickable().click();
        return this;
    }

    public ForgotPassword iconClose() {
        System.out.println("click on close icon");
        page.iconClose().waitUntilClickable().click();
        return this;
    }

    public class Page {
        private WebDriver driver;

        public Page(WebDriver driver) {
            this.driver = driver;
        }

        public BaseElement clickForgotPassword() {
            return new BaseElement(driver, By.xpath("//*[@id=\"loginForm\"]/div[2]/span/a/b"));
        }

        public BaseElement inputEmail_forgotPassword() {
            return new BaseElement(driver, By.xpath("//div[@class='modal-header' and ./h3[normalize-space()='Password Recovery']]/following-sibling::div[@class='modal-body']//input[@placeholder='Email']"));
        }

        public BaseElement btnClose() {
            return new BaseElement(driver, By.xpath("//*[@id=\"passwordrecoverymodal\"]/div/div/div[3]/button"));
        }

        public BaseElement btnSend() {
            return new BaseElement(driver, By.xpath("//input[@value='Send']"));
        }

        public BaseElement iconClose() {
            return new BaseElement(driver, By.xpath("//div[@class='modal-header']/button[@aria-label='Close']"));
        }
    }

}
