import anhtester.LoginPage;
import anhtester.TestData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import selenium.core.BasePage;
import selenium.settings.Browsers;
import settings.Constants;

import java.nio.file.Paths;

public class Sample {
    private final static String WEB_DRIVER_CHROME_DRIVER = "webdriver.chrome.driver";
    private final static String WEB_DRIVER_CHROME_NAME = "chromedriver.exe";
    private final static String WEB_DRIVER_FIREFOX_DRIVER = "webdriver.gecko.driver";
    private final static String RESOURCE_PATH = Paths.get(Paths.get("").toString(), "src", "test", "resources").toString();
    private final static String TEST_URL = "https://demo.anhtester.com/login";


    public static void main(String[] args) throws InterruptedException {
        // Test Steps:
        // 1. Open Browser, settings e.t.c...
        BasePage basePage = new BasePage(Browsers.CHROME);
        WebDriver driver = basePage.getDriver();

        // 2. Open url: https://demo.anhtester.com/login
        basePage.goToUrl(TEST_URL);

        // 3. Enter email, password and click Login button
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail(TestData.EMAIL)
                .enterPassword(TestData.PASSWORD)
                .clickLoginButton();

        // 4. Verify login successfully
        By welcome = By.xpath("//div[@role='alert']");
        String userName = "User 01";
        String title = "Welcome Back " + userName;
        WebElement lblWelcome = driver.findElement(welcome);
        System.out.println("Verify login successfully");
        Assert.assertTrue(lblWelcome.getText().contains(title));

        // 5. Close browser

//        System.out.println("Close browser");
//        driver.quit();

    }
}
