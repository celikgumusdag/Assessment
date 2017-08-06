package Driver;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("ALL")
public class AndroidManager extends DriverManager {
    @Override
    public void createDriver() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "device");
        caps.setCapability("platformName", "Android");
        caps.setCapability("browserName", "Chrome");

        driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

}
