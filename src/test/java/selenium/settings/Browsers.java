package selenium.settings;

public enum Browsers {
    FIREFOX("firefox"), CHROME("chrome"), MICROSOFT_EDGE("edge"),
    SAFARI("safari"), OPERA("opera");

    public final String browserName;

    Browsers(String browserName) {
        this.browserName = browserName;
    }
}
