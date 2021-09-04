package runner;

import cucumber.api.CucumberOptions;

@CucumberOptions(features = "classpath:resources/feature/login/login.feature",
        glue = {"anhtester/steps"},
        monochrome = true, strict = true,
        plugin = {"pretty", "html:target/cucumber-reports/web/login",
                "json:target/cucumber-reports/web/login/Cucumber.json"}
)
public class LoginTest extends TestRunner{
}
