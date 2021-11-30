package pages;

import framework.AutomationWebDriver;
import framework.WebDriverFactory;
import framework.settings.BrowserType;
import framework.settings.WebDriverName;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class GoogleSearchTest {

    private AutomationWebDriver webDriver;

    private GoogleSearch googleSearch;

    @BeforeClass
    public void selectDriver() {
        //Select the Driver type
        this.webDriver = new WebDriverFactory().getWebDriver(WebDriverName.SELENIUM);
    }

    @BeforeMethod
    public void openBrowserChrome() {
        //Select the Browser type
        webDriver.openWebBrowser(BrowserType.CHROME);
        googleSearch = new GoogleSearch(webDriver);
    }

    @Test
    public void testGoogleSearch() {
        googleSearch.search("Hello SriLanka");
    }
}
