import anhtester.LoginPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import selenium.core.BasePage;
import selenium.settings.Browsers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;


public class Sample2 {
    private final static String TEST_URL = "https://demo.anhtester.com/login";


    public static void main(String[] args) throws InterruptedException, IOException {
        // Test Steps:
        // 1. Open Browser, settings e.t.c...
        BasePage page = new BasePage(Browsers.CHROME);
        WebDriver driver = page.getDriver();


        try {
            // 2. Open url: https://demo.anhtester.com/login
            page.goToUrl(TEST_URL);

            LoginPage loginPage = new LoginPage(driver);
            //click on forgot password
//            ForgotPassword forgotPassword = new ForgotPassword(driver);
//            forgotPassword.clickForgotPassword();
//            forgotPassword.enterEmail(TestData.FORGOT_PASSWORD_EMAIL);
////        forgotPassword.clickClose();
//            forgotPassword.clickSend();
//            //navigate browser
//        driver.navigate().refresh();
//        driver.navigate().back();
//        driver.navigate().forward();
            // 3. Enter email, password and click Login button
//        loginPage.enterEmail(TestData.EMAIL);
//        loginPage.enterPassword(TestData.WRONG_PASSWORD);
//        loginPage.clickLoginButton();

            // 4. Verify login fails with message "Wrong User Name Or Password !"
//            String message = TestData.LOGIN_FAILS_MESSAGE;
//            String errorMessage = loginPage.getErrorMessage();
//            Assert.assertTrue(errorMessage.contains(message));

        } catch (Exception e) {
            e.printStackTrace();
            TakesScreenshot scrShot = ((TakesScreenshot) driver);
            File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
            File DestFile = Paths.get(Paths.get("").toString(), "screenshot.png").toFile();

            //Copy file at destination

            FileUtils.copyFile(SrcFile, DestFile);
        } finally {
            // 5. Close browser
            page.quit();
        }

        //  page.quit();

    }
}
