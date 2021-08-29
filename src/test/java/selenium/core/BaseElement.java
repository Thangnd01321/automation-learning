package selenium.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseElement {
    protected WebDriver driver;
    protected By locator;
    protected WebDriverWait wait;

    public BaseElement(WebDriver driver, By locator) {
        this.driver = driver;
        this.locator = locator;
        wait = new WebDriverWait(driver, 20);
    }

    public WebElement findElement() {
        return driver.findElement(locator);
    }

    public BaseElement waitUntilClickable() {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        return this;
    }

    public void click() {
        this.findElement().click();
    }

    public void sendKeys(String input) {
        this.findElement().sendKeys(input);
    }

    public WebElement waitUntilVisible(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public String getText(){
        return this.waitUntilVisible().getText();
    }

    public void clearText(){
        this.findElement().clear();
    }
}
