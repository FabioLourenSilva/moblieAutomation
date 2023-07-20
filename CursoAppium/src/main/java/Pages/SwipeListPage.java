package Pages;

import appiumCourse.BasePage;
import appiumCourse.DriveFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;

import static appiumCourse.DriveFactory.getDriver;

public class SwipeListPage extends BasePage {

    public void SwipeElementLeft(String opcao){
     swipeElement(getDriver().findElement(By.xpath("//*[@text='"+opcao+"']/..")),0.1,0.9);
    }
    public void SwipeElementRight(String opcao){
        swipeElement(getDriver().findElement(By.xpath("//*[@text='"+opcao+"']/..")),0.9,0.1);
    }
    public void clicarBotaoMais(){
       MobileElement botao = getDriver().findElement(By.xpath("//android.widget.TextView[@text='(+)']/.."));
       new TouchAction(getDriver())
               .tap(TapOptions.tapOptions().withElement(
                       ElementOption.element(botao,50,0)
               ))
               .perform();
    }
}
