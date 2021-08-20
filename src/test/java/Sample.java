import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

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
        System.setProperty(WEB_DRIVER_CHROME_DRIVER, Paths.get(RESOURCE_PATH, "drivers", WEB_DRIVER_CHROME_NAME).toString());

        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--start-maximized");

        System.out.println("Open chrome browser");
        ChromeDriver driver = new ChromeDriver(options);
        System.out.println("Maximize browser");
        driver.manage().window().maximize();

        // 2. Open url: https://demo.anhtester.com/login
        driver.get(TEST_URL);

        // 3. Enter email, password and click Login button
        By email = By.xpath("//label[text()='Email']/following-sibling::input");
        WebElement inputEmail = driver.findElement(email);
        Assert.assertTrue(inputEmail.isEnabled());
        System.out.println("Enter user name user01@anhtester.com");
        inputEmail.sendKeys("user01@anhtester.com");


        By password = By.xpath("//label[text()='Password']/following-sibling::input");
        WebElement inputPassword = driver.findElement(password);
        Assert.assertTrue(inputPassword.isEnabled());
        System.out.println("Enter password 123456");
        inputPassword.sendKeys("123456");


        By login = By.xpath("//button[text()='Login']");
        WebElement btnLogin = driver.findElement(login);
        Assert.assertTrue(btnLogin.isEnabled());
        System.out.println("Click on login button");
        btnLogin.click();

        // 4. Verify login successfully
        By welcome = By.xpath("//div[@role='alert']");
        String userName = "User 01";
        String title = "Welcome Back " + userName;
        WebElement lblWelcome = driver.findElement(welcome);
        System.out.println("Verify login successfully");
        Assert.assertTrue(lblWelcome.getText().contains(title));

        // 5. Close browser

        System.out.println("Close browser");
        driver.quit();

    }
}
