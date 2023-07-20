package Testes;

import Pages.MenuPage;
import appiumCourse.BaseTest;
import appiumCourse.DriveFactory;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.ClientInfoStatus;

import static appiumCourse.DriveFactory.getDriver;

public class OpcaoEscondidaTest extends BaseTest {

     private MenuPage menu = new MenuPage();

     @Test
    public void deveEncontrarOpEscondida(){
         WebDriverWait wait = new WebDriverWait(getDriver(),10);
         wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));
         menu.scrollDown();
         menu.acessarOpEscondida();
         Assert.assertEquals("Você achou essa opção",menu.obterMensagemAlerta());
         menu.clicarPorTexto("OK");
     }

}
