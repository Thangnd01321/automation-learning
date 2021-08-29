package anhtester;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import selenium.core.BaseElement;
import selenium.core.BasePage;

public class WelcomePage extends BasePage {
    private Page page;

    public WelcomePage(WebDriver driver) {
        super(driver);
        page = new Page(driver);
    }

    public String getWelcomeMessage() {
        System.out.println("Get welcome message");
        return page.lblWelcome().waitUntilVisible().getText();
    }

    private class Page {
        private WebDriver driver;

        public Page(WebDriver driver) {
            this.driver = driver;
        }

        public BaseElement lblWelcome(){
            return new BaseElement(driver, By.xpath("//div[@role='alert']"));
        }
    }
}
