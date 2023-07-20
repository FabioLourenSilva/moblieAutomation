package Pages;

import appiumCourse.BasePage;
import appiumCourse.DriveFactory;
import io.appium.java_client.functions.ExpectedCondition;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static appiumCourse.DriveFactory.getDriver;

public class MenuPage extends BasePage {

    public void acessarFormulario(){
        clicarPorTexto("Formulário");
    }

    public void acessarSplash(){
        clicarPorTexto("Splash");
    }

    public void acessarAlertas(){
        clicarPorTexto("Alertas");
    }

    public void acessarAbas(){
        clicarPorTexto("Abas");
    }

    public void acessarAccordion(){
        clicarPorTexto("Accordion");
    }

    public void acessarSwipe(){
        clicarPorTexto("Swipe");
    }

    public void acessarCliques(){
        clicarPorTexto("Cliques");
    }
    public void acessarSwipList(){
        clicarPorTexto("Swipe List");
    }

    public void acessarDragNDrop(){
        WebDriverWait wait = new WebDriverWait(getDriver(),10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));
        scrollDown();
        clicarPorTexto("Drag and drop");
    }
    public void acessarSBhibrido(){
        clicarPorTexto("SeuBarriga Híbrido");
    }


    public void acessarOpEscondida(){
        clicarPorTexto("Opção bem escondida");
    }
}
