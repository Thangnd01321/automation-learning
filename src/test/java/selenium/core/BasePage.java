package selenium.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
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
//                break;
                openSafari();
            case FIREFOX:
//                break;
                openFirefox();
            case MICROSOFT_EDGE:
//                break;
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
        System.out.println("Open chrome browser");
        this.driver = new ChromeDriver(options);
        System.out.println("Maximize browser");
        driver.manage().window().maximize();
    }

    public void openFirefox() {
        System.setProperty(SeleniumConstant.WEB_DRIVER_FIREFOX_DRIVER, Paths.get(
                Constants.RESOURCE_PATH, "drivers", SeleniumConstant.WEB_DRIVER_FIREFOX_NAME).toString());
        FirefoxOptions options_firefox = new FirefoxOptions();
        System.out.println("Open firefox browser");
        this.driver = new FirefoxDriver(options_firefox);
        System.out.println("Maximize firefox browser");
        driver.manage().window().maximize();
    }

    public void openOpera() {
        System.setProperty(SeleniumConstant.WEB_DRIVER_OPERA_DRIVER, Paths.get(
                Constants.RESOURCE_PATH, "drivers", SeleniumConstant.WEB_DRIVER_OPERA_NAME).toString());
        OperaOptions options_opera = new OperaOptions();
        System.out.println("Open opera browser");
        this.driver = new OperaDriver(options_opera);
        System.out.println("Maximize opera browser");
        driver.manage().window().maximize();
    }

    public void openMicrosoftEdge() {
        System.setProperty(SeleniumConstant.WEB_DRIVER_EDGE_DRIVER, Paths.get(
                Constants.RESOURCE_PATH, "drivers", SeleniumConstant.WEB_DRIVER_EDGE_NAME).toString());
        EdgeOptions options_edge = new EdgeOptions();
        System.out.println("Open edge browser");
        this.driver = new EdgeDriver(options_edge);
        System.out.println("Maximize edge browser");
        driver.manage().window().maximize();
    }

    public void openSafari() {
   /*     System.setProperty(SeleniumConstant.WEB_DRIVER_SAFARI_DRIVER, Paths.get(
                Constants.RESOURCE_PATH, "drivers", SeleniumConstant.WEB_DRIVER_SAFARI_NAME).toString());
        SafariOptions options_safari= new SafariOptions();
        System.out.println("Open safari browser");
        this.driver = new SafariDriver(options_safari);
        System.out.println("Maximize safari browser");
        driver.manage().window().maximize();

    */
    }

    public WebDriver getDriver() {
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
