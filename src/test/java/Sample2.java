import anhtester.ForgotPassword;
import anhtester.LoginPage;
import anhtester.TestData;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import selenium.core.BasePage;
import selenium.settings.Browsers;


public class Sample2 {
    private final static String TEST_URL = "https://demo.anhtester.com/login";


    public static void main(String[] args) throws InterruptedException {
        // Test Steps:
        // 1. Open Browser, settings e.t.c...
        BasePage page = new BasePage(Browsers.CHROME);
        WebDriver driver = page.getDriver();

        // 2. Open url: https://demo.anhtester.com/login
        page.goToUrl(TEST_URL);

        LoginPage loginPage = new LoginPage(driver);
        //click on forgot password
        ForgotPassword forgotPassword = new ForgotPassword(driver);
        forgotPassword.clickForgotPassword();
//        forgotPassword.enterEmail(TestData.FORGOT_PASSWORD_EMAIL);
//        forgotPassword.clickClose();
//        forgotPassword.clickSend();
        //navigate browser
        driver.navigate().refresh();
//        driver.navigate().back();
//        driver.navigate().forward();
        // 3. Enter email, password and click Login button
        loginPage.enterEmail(TestData.EMAIL);
        loginPage.enterPassword(TestData.WRONG_PASSWORD);
        loginPage.clickLoginButton();

        // 4. Verify login fails with message "Wrong User Name Or Password !"
        String message = TestData.LOGIN_FAILS_MESSAGE;
        String errorMessage = loginPage.getErrorMessage();
        Assert.assertTrue(errorMessage.contains(message));

// 5. Close browser
        //  page.quit();

    }
}
