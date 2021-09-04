package anhtester.steps;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.AfterStep;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import factory.DataContainer;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import selenium.core.BasePage;
import selenium.settings.Browsers;

import java.io.IOException;

public class SetupSteps {
    DataContainer data;

    public SetupSteps(DataContainer data) {
        this.data = data;
    }

    @Given("Web browser is open")
    public void webBrowserIsOpen() {
        BasePage page = new BasePage(Browsers.CHROME);
        data.page = page;
    }

    @And("User open login page: {string}")
    public void userIsOnLoginPage(String url) {
        data.page.goToUrl(url);
    }

//    @AfterStep
//    public void afterStep(Scenario scenario){
//        byte[] screenshot = ((TakesScreenshot) data.page.getDriver()).getScreenshotAs(OutputType.BYTES);
//
//        scenario.embed(screenshot, "image/png");
//    }

    @After
    public void afterScenario(Scenario scenario) {
        System.out.println("Close Browser");

        byte[] screenshot = ((TakesScreenshot) data.page.getDriver()).getScreenshotAs(OutputType.BYTES);

        scenario.embed(screenshot, "image/png");

        data.page.quit();
    }
}
