package framework;

import framework.exceptions.ElementSelectorNotFoundException;
import framework.exceptions.WebDriverInitializationException;
import framework.exceptions.WebDriverWaitException;
import framework.settings.BrowserType;
import framework.settings.ElementSelector;
import framework.settings.MouseActionType;

import java.util.concurrent.TimeUnit;

public interface AutomationWebDriver {
    AutomationWebDriver openWebBrowser(BrowserType browserType);

    AutomationWebDriver stopWebBrowser();

    AutomationWebDriver navigateToUrl(String url) throws WebDriverInitializationException;

    AutomationWebElement findWebElement(String id, ElementSelector selector) throws ElementSelectorNotFoundException;

    void waitFor(int time, TimeUnit timeType) throws WebDriverWaitException;
}
