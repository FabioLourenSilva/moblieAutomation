package Base;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriveFactory {

    private static AndroidDriver<MobileElement> driver;

    public static AndroidDriver<MobileElement> getDriver() {
        if (driver == null) {
           createDriver();
        }
        return driver;
    }

    private static void createDriver(){
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName","Android");
        desiredCapabilities.setCapability("appium:deviceName","emulator-5554");
        desiredCapabilities.setCapability("appium:automationName","uiautomator2");
//        desiredCapabilities.setCapability("appium:appPackage","br.com.timbrasil.timmais.dev");
//        desiredCapabilities.setCapability("appium:appActivity","com.example.base_app.MainActivity");
        desiredCapabilities.setCapability("appium:appPackage","br.com.timbrasil.timmais");
        desiredCapabilities.setCapability("appium:appActivity","com.example.base_app.MainActivity");
        try {
            URL appiumServerURL = new URL("http://127.0.0.1:4723/wd/hub");
            driver = new AndroidDriver<>(appiumServerURL, desiredCapabilities);
        }catch (MalformedURLException e){
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static void killDriver(){
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }


}
