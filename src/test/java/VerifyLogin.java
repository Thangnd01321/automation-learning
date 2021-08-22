import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;


public class VerifyLogin {
    private final static String TEST_URL = "https://demo.anhtester.com/login";
    private static ChromeDriver driver;


    // 3. Enter email, password and click Login button
    public static void enterUserAndPass(String username, String pass) {
        String expectedUsername = "fsdafgsdg";
        String expectedpass = "09099709";
        // open Chrome
//        ChromeOptions options = new ChromeOptions();
//        System.out.println("Open chrome browser");
//        ChromeDriver driver = new ChromeDriver(options);
//        System.out.println("Maximize browser");
//        driver.manage().window().maximize();
//        driver.get(TEST_URL);


        // enter email
        By email = By.xpath("//label[text()='Email']/following-sibling::input");
        WebElement inputEmail = driver.findElement(email);
        Assert.assertTrue(inputEmail.isEnabled());
        System.out.println("Enter user name");
        inputEmail.sendKeys(username);
        // enter password
        By password = By.xpath("//label[text()='Password']/following-sibling::input");
        WebElement inputPassword = driver.findElement(password);
        Assert.assertTrue(inputPassword.isEnabled());
        System.out.println("Enter password");
        inputPassword.sendKeys(pass);
        // click login
        By login = By.xpath("//button[text()='Login']");
        WebElement btnLogin = driver.findElement(login);
        Assert.assertTrue(btnLogin.isEnabled());
        System.out.println("Click on login button");
        btnLogin.click();

        // verify email & pass correct or incorrect
        if (username == expectedUsername && pass == expectedpass) {

            System.out.println("Login success");
            By welcome = By.xpath("//div[@role='alert']");
            String userName = "User 01";
            String title = "Welcome Back " + userName;
            WebElement lblWelcome = driver.findElement(welcome);
            System.out.println("Verify login successfully");
            Assert.assertTrue(lblWelcome.getText().
                    contains(title));

        } else {

            By errorLogin = By.xpath("/html/body/div[2]/div/div[1]/div[2]/div");
            WebElement InputErrorLogin = driver.findElement(errorLogin);
            Assert.assertTrue(InputErrorLogin.isDisplayed());
            System.out.println("Invalid email");
        }
        //5. Close browser
/*
        System.out.println("Close browser");
        driver.quit();
*/
    }

    public void openChrome() {
        ChromeOptions options = new ChromeOptions();
        System.out.println("Open chrome browser");
        //ChromeDriver driver = new ChromeDriver(options);
        this.driver = new ChromeDriver(options);
        System.out.println("Maximize browser");
        driver.manage().window().maximize();
        driver.get(TEST_URL);

    }
}

//    public static void welCome () {
//        // 4. Verify login successfully
//        By welcome = By.xpath("//div[@role='alert']");
//        String userName = "User 01";
//        String title = "Welcome Back " + userName;
//        WebElement lblWelcome = driver.findElement(welcome);
//        System.out.println("Verify login successfully");
//        Assert.assertTrue(lblWelcome.getText().
//
//                contains(title));
//
//        // 5. Close browser
//
//        System.out.println("Close browser");
//        driver.quit();
//    }


