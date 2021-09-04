package anhtester.steps;

import anhtester.WelcomePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import factory.DataContainer;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class DashboardSteps {
    WelcomePage page;

    public DashboardSteps(DataContainer data) {
        WebDriver driver = data.page.getDriver();
        page = new WelcomePage(driver);
    }

    @Then("User is on Dashboard")
    public void userIsOnDashboard(DataTable dataTable) {
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> map : list) {
            String url = map.get("url");
            Assert.assertEquals(page.getUrl(), url);
        }
    }

    @And("User should see message {string}")
    public void userShouldSeeMessage(String message) {
        String welcomeMessage = page.getWelcomeMessage();
        Assert.assertTrue(welcomeMessage.contains(message));
    }
}
