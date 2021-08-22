package selenium.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import selenium.settings.Browsers;
import selenium.settings.SeleniumConstant;
import settings.Constants;

import java.nio.file.Paths;

public class BasePage {
    private WebDriver driver;

    public BasePage(Browsers browser) {
        // Open browser
        switch (browser) {
            case OPERA:
                break;
            case CHROME:
                openChrome();
            case SAFARI:
                openSafari();
            case FIREFOX:
                openFirefox();
            case MICROSOFT_EDGE:
                openMicrosoftEdge();
            default:
                openChrome();
        }
    }

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public void openChrome() {
        System.setProperty(SeleniumConstant.WEB_DRIVER_CHROME_DRIVER, Paths.get(
                Constants.RESOURCE_PATH, "drivers", SeleniumConstant.WEB_DRIVER_CHROME_NAME).toString());

        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--start-maximized");

        System.out.println("Open chrome browser");
        this.driver = new ChromeDriver(options);
        System.out.println("Maximize browser");
        driver.manage().window().maximize();
    }

    public void openFirefox() {
    }

    public void openMicrosoftEdge() {
    }

    public void openSafari() {
    }

    public WebDriver getDriver(){
        return driver;
    }

    public void refresh(){
        driver.navigate().refresh();
    }

    public void goToUrl(String url){
        driver.navigate().to(url);
    }

    public void quit(){
        System.out.println("Quit driver!!!");
        driver.quit();
    }

    public void close(){
        System.out.println("Close browser!!!");
        driver.close();
    }
}
