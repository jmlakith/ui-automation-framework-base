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
    private final AutomationWebDriver webDriver;

    public GoogleSearch(AutomationWebDriver webDriver) {
        this.webDriver = webDriver;
        navigateToUrl();
    }

    private void navigateToUrl() {
        try {
            this.webDriver.navigateToUrl(URL);
        } catch (WebDriverInitializationException e) {
            //TODO: Log this in future.
            e.printStackTrace();
        }
    }

    public void search(String text) {
        try {
            this.webDriver.findWebElement(TEXT_BOX, ElementSelector.NAME).typeValue(text);
            this.webDriver.waitFor(2, TimeUnit.SECONDS);
            this.webDriver.findWebElement(SEARCH_BUTTON, ElementSelector.NAME).click();
            this.webDriver.waitFor(2, TimeUnit.SECONDS);

            //Close the webDriver
            this.webDriver.stopWebBrowser();

        } catch (ElementSelectorNotFoundException | WebDriverWaitException e) {
            e.printStackTrace();
        }
    }
}
