import java.nio.file.Paths;

public class Main {
    private final static String WEB_DRIVER_CHROME_DRIVER = "webdriver.chrome.driver";
    private final static String WEB_DRIVER_CHROME_NAME = "chromedriver.exe";
    private final static String WEB_DRIVER_FIREFOX_DRIVER = "webdriver.gecko.driver";
    private final static String RESOURCE_PATH = Paths.get(Paths.get("").toString(), "src", "test", "resources").toString();
    private final static String TEST_URL = "https://demo.anhtester.com/login";


    public static void main(String[] args) throws InterruptedException {
        // Test Steps:
        // 1. Open Browser, settings e.t.c...
        System.setProperty(WEB_DRIVER_CHROME_DRIVER, Paths.get(RESOURCE_PATH, "drivers", WEB_DRIVER_CHROME_NAME).toString());

        //  VerifyLogin.openChrome();
        //  System.out.println("open success");
        VerifyLogin.enterUserAndPass("abvcjksgf", "1233414");
    }
}

