package Pages;

import appiumCourse.BasePage;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;

import static appiumCourse.DriveFactory.*;

public class CliquesPage extends BasePage {


    public void cliqueLongo() {
        new AndroidTouchAction(getDriver())
                .longPress(ElementOption.element(getDriver().findElement(By.xpath("//*[@text='Clique Longo']"))))
                .perform();

    }
    public void cliqueDuplo() {
        clicarPorTexto("Clique duplo");
        clicarPorTexto("Clique duplo");

    }

    public String obterTextoCampo(){

        return getDriver().findElement(By.xpath("(//android.widget.TextView)[3]")).getText();
    }
}
