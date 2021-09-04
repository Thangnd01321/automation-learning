package anhtester;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import selenium.core.BaseElement;
import selenium.core.BasePage;

public class Dashboard extends BasePage {

    private Page page;

    public Dashboard(WebDriver driver) {
        super(driver);
        page = new Page(driver);
    }

    public Dashboard clickDashboard() {
        System.out.println("Click on dashboard");
        page.clickDashboard().waitUntilClickable().click();

        return this;
    }

    public class Page {
        private WebDriver driver;

        public Page(WebDriver driver) {
            this.driver = driver;
        }

        public BaseElement clickDashboard() {
//            return new BaseElement(driver, By.xpath("//span[@class='logo-mini']"));
            return new BaseElement(driver, By.xpath("//*[@class='ti-dashboard'] "));
        }

    }
}