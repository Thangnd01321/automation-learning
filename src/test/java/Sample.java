import anhtester.LoginPage;
import anhtester.TestData;
import anhtester.WelcomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import selenium.core.BasePage;
import selenium.settings.Browsers;

public class Sample {
    private static final String TEST_URL = "https://demo.anhtester.com/login";

    public static void main(String[] args) throws InterruptedException {
        // Test Steps:
        // 1. Open Browser, settings e.t.c...
        BasePage page = new BasePage(Browsers.CHROME);
        WebDriver driver = page.getDriver();

        // 2. Open url: https://demo.anhtester.com/login
        page.goToUrl(TEST_URL);

        LoginPage loginPage = new LoginPage(driver);
        // 3. Enter email, password and click Login button
        loginPage.enterEmail(TestData.EMAIL);
        loginPage.enterPassword(TestData.PASSWORD);
        loginPage.clickLoginButton();

        // 4. Verify login successfully
        WelcomePage welcomePage = new WelcomePage(driver);

        String title = String.format(TestData.WELCOME_MESSAGE, TestData.USER_NAME);
        String welcomeMessage = welcomePage.getWelcomeMessage();
        System.out.println("Verify login successfully");
        Assert.assertTrue(welcomeMessage.contains(title));

        // 5. Close browser
        page.quit();

    }
}
