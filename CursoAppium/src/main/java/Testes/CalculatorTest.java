package Testes;

import appiumCourse.Commons;
import appiumCourse.EmulatorConfig;
import io.appium.java_client.MobileElement;
import org.junit.Assert;
import org.junit.Test;
import java.net.MalformedURLException;

public class CalculatorTest{

     EmulatorConfig start = new EmulatorConfig();
     Commons base = new Commons();

    @Test
    public void realizarSomaEmulator() throws MalformedURLException {

        start.EmulatorConfig("Android","emulator-5554","uiautomator2",
                "com.google.android.calculator","com.android.calculator2.Calculator");

        MobileElement el1 = (MobileElement) start.getDriver().findElementByAccessibilityId("2");
        el1.click();
        MobileElement el2 = (MobileElement) start.getDriver().findElementByAccessibilityId("plus");
        el2.click();
        MobileElement el3 = (MobileElement) start.getDriver().findElementByAccessibilityId("2");
        el3.click();
        MobileElement el4 = (MobileElement) start.getDriver().findElementByAccessibilityId("equals");
        el4.click();
        MobileElement el15 = (MobileElement) start.getDriver().findElementByAccessibilityId("4");
    }

    @Test
    public void realizarSomaDeviceFisico() throws MalformedURLException {

        start.EmulatorConfig("Android","emulator-5554","uiautomator2",
                "com.sec.android.app.popupcalculator","com.sec.android.app.popupcalculator.Calculator");

        MobileElement el1 = (MobileElement) start.getDriver().findElementByAccessibilityId("2");
        el1.click();
        MobileElement el2 = (MobileElement) start.getDriver().findElementByAccessibilityId("Mais");
        el2.click();
        MobileElement el3 = (MobileElement) start.getDriver().findElementByAccessibilityId("2");
        el3.click();
        MobileElement el4 = (MobileElement) start.getDriver().findElementByAccessibilityId("Igual");
        el4.click();
        MobileElement el15 = (MobileElement) start.getDriver().findElementByAccessibilityId("4 Resultado do cálculo");
        Assert.assertEquals("4",el15.getText());
        System.out.println("Resultado = "+el15.getText());
    }

}
