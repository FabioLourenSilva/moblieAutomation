package Base;


import Runner.RunTimMais;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
                desiredCapabilities.setCapability("deviceName", "emulator-5554");
                desiredCapabilities.setCapability("automationName", "uiautomator2");
                desiredCapabilities.setCapability("appPackage", "br.com.timbrasil.meutim");
                desiredCapabilities.setCapability("appActivity", "com.accenture.meutim.activities.SplashScreenActivity");
//                desiredCapabilities.setCapability("noReset", true);

                try {
                    URL appiumServerURL = new URL("http://127.0.0.1:4723/wd/hub");
                    driver = new AndroidDriver<>(appiumServerURL, desiredCapabilities);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            }

            else if (soRunner.equals("iOS")) {
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

            else {
                DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                desiredCapabilities.setCapability("platformName", "Android");
                desiredCapabilities.setCapability("appium:deviceName", "emulator-5554");
                desiredCapabilities.setCapability("appium:browserName", "Chrome");

                try {
                    URL appiumServerURL = new URL("http://127.0.0.1:4723/wd/hub");
                    driver = new AndroidDriver<>(appiumServerURL, desiredCapabilities);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }

                // Tempo de espera implícita para garantir que o driver esteja disponível
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

                driver.get("https://dev-timmais.timwe.com/web/");

                // Espera explícita para garantir que a URL carregou corretamente
                WebDriverWait wait = new WebDriverWait(driver, 20);
                wait.until(ExpectedConditions.urlToBe("https://dev-timmais.timwe.com/web/"));
            }

        }

    public static void switchContext() {
        for (String context : driver.getContextHandles()) {
            if (context.contains("NATIVE_APP")) {
                driver.context(context);
                break;
            }
        }
    }

    public static void switchToNativeContext(String context) {
        driver.context(context);
    }

    public static void killDriver(){
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }

//Capability casca webview
//                desiredCapabilities.setCapability("appPackage", "com.example.timmais_webview");
//                desiredCapabilities.setCapability("appActivity", "com.example.timmais_webview.MainActivity");

}
