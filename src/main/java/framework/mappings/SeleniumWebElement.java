package framework.mappings;

import framework.AutomationWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumWebElement implements AutomationWebElement {
    private WebElement webElement;

    public SeleniumWebElement(WebDriver webDriver, By selector) {
        this.webElement = webDriver.findElement(selector);
    }

    @Override
    public AutomationWebElement typeValue(String value) {
        webElement.sendKeys(value);
        return this;
    }

    @Override
    public AutomationWebElement click() {
        webElement.click();
        return this;
    }


}
