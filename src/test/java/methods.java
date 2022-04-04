import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.slf4j.LoggerFactory;

import java.nio.channels.Selector;

public class methods {


    public Logger logger = LoggerFactory.getLogger(getClass());
    public AppiumDriver<MobileElement> appiumDriver;
    public FluentWait<AppiumDriver> fluentWait;
    public boolean localAndroid = true ;
    public Selector selector ;



    @BeforeScenario

    public void setUp() throws MalformedURLException {
        if (localAndroid){
            System.out.println("Android testi başlıyor!");
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5554");
            desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"ozdilekteyim başlatılıyor");
            desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"ozdilekteyim.MainActivity");
            desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 3000);
            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            appiumDriver = new AndroidDriver(url, desiredCapabilities);
        }else{
            System.out.println("IOS testi başlatılıyor");
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities
                    .setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
            desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
            desiredCapabilities
                    .setCapability(MobileCapabilityType.UDID, "00008030-00157936018B802E");
            desiredCapabilities
                    .setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.pozitron.ozdilek");
            desiredCapabilities
                    .setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone");
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "14.7.1");
            desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 6000);
            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            appiumDriver = new IOSDriver(url, desiredCapabilities);

        }
        @After
        public void quitTest() {
            appiumDriver.quit();
        }
    }
}
