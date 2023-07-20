package appiumCourse;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;

import java.net.MalformedURLException;


public class Commons{

    EmulatorConfig start = new EmulatorConfig();
    public void clickElement(String element) {
        MobileElement el1 = (MobileElement) start.getDriver().findElementByAccessibilityId("element");
        el1.click();
    }

    public void lookElement(String element){
        MobileElement el6 =  start.getDriver().findElementById(element);
    }

    public void validateConteudo(String conteudo,String esperado){
        Assert.assertEquals(esperado,conteudo);
    }

    public void cleanDevice(){

    }

}
