package pages;

import framework.AutomationWebDriver;
import framework.exceptions.ElementSelectorNotFoundException;
import framework.exceptions.WebDriverInitializationException;
import framework.exceptions.WebDriverWaitException;
import framework.settings.BrowserType;
import framework.settings.ElementSelector;

import java.util.concurrent.TimeUnit;

public class GoogleSearch {
    private static final String SEARCH_BUTTON = "btnK";
    private static final String TEXT_BOX = "q";
    private static final String URL = "https://www.google.lk/";
    private final AutomationWebDriver webBrowser;

    public GoogleSearch(AutomationWebDriver webDriver) {
        this.webBrowser = webDriver;
        initializeWebDriver();
    }

    private void initializeWebDriver() {
        try {
            this.webBrowser.openWebBrowser(BrowserType.CHROME).navigateToUrl(URL);
        } catch (WebDriverInitializationException e) {
            //TODO: Log this in future.
            e.printStackTrace();
        }
    }

    public void search(String text) {
        try {
            this.webBrowser.findWebElement(TEXT_BOX, ElementSelector.NAME).typeValue(text);
            this.webBrowser.waitFor(2, TimeUnit.SECONDS);
            this.webBrowser.findWebElement(SEARCH_BUTTON, ElementSelector.NAME).click();
            this.webBrowser.waitFor(5, TimeUnit.SECONDS);

            //Close the webDriver
            this.webBrowser.stopWebBrowser();

        } catch (ElementSelectorNotFoundException | WebDriverWaitException e) {
            e.printStackTrace();
        }
    }
}
