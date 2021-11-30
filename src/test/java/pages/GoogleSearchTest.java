package pages;

import framework.WebBrowserFactory;
import framework.settings.WebDriverName;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class GoogleSearchTest {

    GoogleSearch googleSearch;

    @BeforeMethod
    public void setUp() {
        googleSearch = new GoogleSearch(new WebBrowserFactory().getBrowser(WebDriverName.SELENIUM));
    }

    @Test
    public void testSearch() {
        googleSearch.search("text");
    }
}
