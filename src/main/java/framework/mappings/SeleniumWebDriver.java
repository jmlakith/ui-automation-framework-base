package framework.mappings;

import framework.AutomationWebDriver;
import framework.AutomationWebElement;
import framework.exceptions.ElementSelectorNotFoundException;
import framework.exceptions.WebDriverInitializationException;
import framework.exceptions.WebDriverWaitException;
import framework.settings.BrowserType;
import framework.settings.ElementSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class SeleniumWebDriver implements AutomationWebDriver {

    private WebDriver webDriver;

    @Override
    public AutomationWebDriver openWebBrowser(BrowserType browserType) {
        //TODO: Read configs from the application.properties in future
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Dell\\IdeaProjects\\ui-automation-framework-base\\chromedriver.exe");
        //TODO: Create a Selenium browser factory
        ChromeOptions options = new ChromeOptions();
        //Headless mode on currently
        options.addArguments("--headless", "--window-size=1920,1200");
        webDriver = new ChromeDriver(options);
        return this;
    }

    @Override
    public AutomationWebDriver stopWebBrowser() {
        webDriver.quit();
        return this;
    }

    @Override
    public AutomationWebDriver navigateToUrl(String url) throws WebDriverInitializationException {
        if (webDriver == null) {
            throw new WebDriverInitializationException("Initialize the web driver by starting it first");
        }
        webDriver.get(url);
        return this;
    }

    @Override
    public AutomationWebElement findWebElement(String locator, ElementSelector selector) throws ElementSelectorNotFoundException {
        By selectedLocator;
        switch (selector) {
            case ID:
                selectedLocator = By.id(locator);
                break;
            case NAME:
                selectedLocator = By.name(locator);
                break;
            case XPATH:
                selectedLocator = By.xpath(locator);
                break;
            default:
                throw new ElementSelectorNotFoundException("Element selector is not found");
        }
        return new SeleniumWebElement(webDriver, selectedLocator);
    }

    @Override
    public void waitFor(int time, TimeUnit timeType) throws WebDriverWaitException {

        if (timeType == TimeUnit.SECONDS) {
            try {
                Thread.sleep(time * 1000L);
            } catch (InterruptedException e) {
                throw new WebDriverWaitException("Error while trying the action");
            }
        }

    }


}
