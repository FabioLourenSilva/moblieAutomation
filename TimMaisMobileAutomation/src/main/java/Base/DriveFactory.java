package Base;


import Runner.RunTimMais;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class DriveFactory  {


    private static AppiumDriver<MobileElement> driver;

    static String soRunner;
    static {
        RunTimMais runTimMais = new RunTimMais();
        soRunner = runTimMais.getSo();
    }

    public static AppiumDriver<MobileElement> getDriver() {
        if (driver == null) {
            createDriver();
        }
        return driver;
    }


        private static void createDriver() {

            if (soRunner.equals("android")) {

                DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                desiredCapabilities.setCapability("platformName", "Android");
                desiredCapabilities.setCapability("appium:deviceName", "emulator-5554");
                desiredCapabilities.setCapability("appium:automationName", "uiautomator2");
                desiredCapabilities.setCapability("appium:appPackage", "br.com.timbrasil.timmais.dev");
                desiredCapabilities.setCapability("appium:appActivity", "com.example.base_app.MainActivity");
                try {
                    URL appiumServerURL = new URL("http://127.0.0.1:4723/wd/hub");
                    driver = new AndroidDriver<>(appiumServerURL, desiredCapabilities);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            }

            else {
                DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                desiredCapabilities.setCapability("appium:platformName", "iOS");
                desiredCapabilities.setCapability("appium:deviceName", "iPhone de Fabio");
                desiredCapabilities.setCapability("appium:automationName", "XCUITest");
                desiredCapabilities.setCapability("appium:udid", "00008030-001619C00138402E");
//                desiredCapabilities.setCapability("appium:app", "/Users/fabiolourenco/Downloads/base_app6.ipa");
                desiredCapabilities.setCapability("appium:bundleId", "br.com.timbrasil.timmais");
                desiredCapabilities.setCapability("appium:xcodeOrgId", "C773E24UZ4");
                desiredCapabilities.setCapability("appium:xcodeSigningId", "iPhone Developer");
                desiredCapabilities.setCapability("appium:autoAcceptAlerts", true);

                try {
                    URL appiumServerURL = new URL("http://127.0.0.1:4723/wd/hub");
                    driver = new IOSDriver<>(appiumServerURL,
                            desiredCapabilities);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            }


        }

    public static void killDriver(){
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }

}
