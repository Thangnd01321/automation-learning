package testng;

import anhtester.LoginPage;
import anhtester.TestData;
import anhtester.WelcomePage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.core.BasePage;
import selenium.settings.Browsers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class LoginTest {
    BasePage page;

    @BeforeMethod
    public void beforeMethod(){
        page = new BasePage(Browsers.CHROME);
        page.goToUrl(TestData.TEST_URL);
    }

    @Test(description = "Verify test case: User can login successfully")
    public void verifyLoginSuccess(){
        WebDriver driver = page.getDriver();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail(TestData.EMAIL)
                .enterPassword(TestData.WRONG_PASSWORD)
                .clickLoginButton();

        WelcomePage welcomePage = new WelcomePage(driver);
        String welcomeMessage = welcomePage.getWelcomeMessage();

        String expectedMessage = String.format(TestData.WELCOME_MESSAGE, TestData.USER_NAME);
        Assert.assertTrue(welcomeMessage.contains(expectedMessage));
    }

    @Test(description = "Verify test case: User login fail if enter wrong username or password")
    public void verifyLoginFail(){
        WebDriver driver = page.getDriver();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail(TestData.EMAIL)
                .enterPassword(TestData.WRONG_PASSWORD)
                .clickLoginButton();

        String errorMessage = loginPage.getErrorMessage();
        String expectedMessage = TestData.LOGIN_FAILS_MESSAGE;
        Assert.assertTrue(errorMessage.contains(expectedMessage));

    }

    @AfterMethod
    public void afterMethod(ITestResult result) throws IOException {
        TakesScreenshot scrShot = ((TakesScreenshot) page.getDriver());
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile = Paths.get(Paths.get("").toString(), result.getMethod().getMethodName() + ".png").toFile();

        //Copy file at destination

        FileUtils.copyFile(SrcFile, DestFile);

        page.quit();
    }

}
