package framework;

import framework.mappings.SeleniumWebDriver;
import framework.settings.WebDriverName;

import java.util.HashMap;
import java.util.Map;

public class WebBrowserFactory {

    private final Map<WebDriverName, AutomationWebDriver> driverList = new HashMap<>();

    public WebBrowserFactory() {
        init();
    }

    void init() {
        driverList.put(WebDriverName.SELENIUM, new SeleniumWebDriver());
    }

    public AutomationWebDriver getBrowser(WebDriverName name) {

        return driverList.get(name);
    }
}
