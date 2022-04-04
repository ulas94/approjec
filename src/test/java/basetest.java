import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

public class basetest {
    WebDriver driver;
    DesiredCapabilities capabilities;
    ChromeOptions chromeOptions;
    protected static WebDriver webdriver;

    @Before
    public void BeforeTest() {
        chromeOptions = new ChromeOptions();
        capabilities = DesiredCapabilities.chrome();
        chromeOptions.addArguments("--disable-notifications");
        System.setProperty("webdriver.chrome.driver", "web_driver/chromedriver");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

        @After
        public void quitTest () {
            driver.quit();

        }
    }
}

