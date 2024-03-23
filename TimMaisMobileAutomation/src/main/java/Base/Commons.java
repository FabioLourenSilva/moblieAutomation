package Base;

import io.appium.java_client.MobileElement;
import org.junit.Assert;


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
