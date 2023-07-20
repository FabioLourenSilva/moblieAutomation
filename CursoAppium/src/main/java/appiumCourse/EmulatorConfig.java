package appiumCourse;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;
public class EmulatorConfig {

    public AndroidDriver<MobileElement>  driver;


    public void EmulatorConfig(String platformName, String deviceName, String automationName, String appPackage, String appActivity) throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", platformName);
        desiredCapabilities.setCapability("appium:deviceName", deviceName);
        desiredCapabilities.setCapability("appium:automationName", automationName);
        desiredCapabilities.setCapability("appium:appPackage", appPackage);
        desiredCapabilities.setCapability("appium:appActivity", appActivity);
        URL appiumServerURL = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver<>(appiumServerURL, desiredCapabilities);
    }

    public AndroidDriver<MobileElement> getDriver(){
        return driver;
    }

}
