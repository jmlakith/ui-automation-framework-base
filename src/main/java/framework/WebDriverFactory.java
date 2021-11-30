package framework;

import framework.mappings.SeleniumWebDriver;
import framework.settings.WebDriverName;

import java.util.HashMap;
import java.util.Map;

public class WebDriverFactory {

    private final Map<WebDriverName, AutomationWebDriver> driverList = new HashMap<>();

    public WebDriverFactory() {
        init();
    }

    void init() {
        driverList.put(WebDriverName.SELENIUM, new SeleniumWebDriver());
    }

    public AutomationWebDriver getWebDriver(WebDriverName name) {
        return driverList.get(name);
    }
}
