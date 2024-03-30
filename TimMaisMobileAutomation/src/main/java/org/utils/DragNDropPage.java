package org.utils;

import Base.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;

import java.util.List;

import static Base.DriveFactory.getDriver;

public class DragNDropPage extends BasePage {

    public void arrastar(String origem, String destino){
    MobileElement inicio =  getDriver().findElement(By.xpath("//*[@text='"+origem+"']"));
    MobileElement fim =  getDriver().findElement(By.xpath("//*[@text='"+destino+"']"));
    new TouchAction(getDriver())
            .longPress(ElementOption.element(inicio))
            .moveTo(ElementOption.element(fim))
            .release()
            .perform();
    }

    public String[] obterLista(){
        List<MobileElement> elements = getDriver().findElements(By.className("android.widget.TextView"));
        String [] retorno = new String[elements.size()];
        for (int i = 0; i < elements.size(); i++){
            retorno[i] = elements.get(i).getText();
            System.out.print("\"" + retorno[i] + "\", ");
        }
        return retorno;
    }
}
