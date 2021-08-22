package anhtester;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import selenium.core.BasePage;

public class WelcomePage extends BasePage {
    By lblWelcome = By.xpath("//div[@role='alert']");

    public WelcomePage(WebDriver driver) {
        super(driver);
    }

    public String getWelcomeMessage(){
        System.out.println("Get welcome message");
        return getDriver().findElement(this.lblWelcome).getText();
    }
}
