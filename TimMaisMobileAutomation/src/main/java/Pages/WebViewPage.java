package Pages;

import Base.BasePage;
import org.openqa.selenium.By;

import java.util.Set;

import static Base.DriveFactory.getDriver;

public class WebViewPage extends BasePage {

    public void entrarContextoWeb(){
        Set<String> contextHandles = getDriver().getContextHandles();
        for(String valor: contextHandles){
            System.out.println(valor);
        }
        getDriver().context((String) contextHandles.toArray()[1]);
    }
    public void setEmail(String valor){
        getDriver().findElement(By.id("email")).sendKeys(valor);
    }

    public void sairContextoWeb(){

        getDriver().context((String) getDriver().getContextHandles().toArray()[0]);
    }
}
