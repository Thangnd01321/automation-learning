package anhtester;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import selenium.core.BaseElement;
import selenium.core.BasePage;

public class MenuPage extends BasePage {
    private Page page;

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    public MenuPage searchProduct() {
        System.out.println("click on Search product");
        page.searchProduct().waitUntilClickable().sendKeys("abc");
        return this;
    }

    public MenuPage selectOption() {
        System.out.println("click on select option");
        page.selectOption().waitUntilVisible().click();
        return this;
    }

    public class Page {
        private WebDriver driver;

        public Page(WebDriver driver) {
            this.driver = driver;
        }

        public BaseElement searchProduct() {
            return new BaseElement(driver, By.xpath("//input[@placeholder='Search Product']"));
        }

        public BaseElement selectOption() {
            return new BaseElement(driver, By.xpath("//*[@id='select2-productlist-df-container']"));
        }
    }
}
