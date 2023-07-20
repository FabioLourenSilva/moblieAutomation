package Testes;

import Pages.FormularioPage;
import Pages.MenuPage;
import appiumCourse.BaseTest;
import appiumCourse.DriveFactory;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;

public class CampoTreinamento extends BaseTest {

    private MenuPage menu = new MenuPage();
    private FormularioPage page = new FormularioPage();
    public AndroidDriver<MobileElement> driver;

    @Before
    public void inicializarAppium(){
        driver = DriveFactory.getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void devePreencherCampoTexto(){
        menu.acessarFormulario();
        page.escreverNome("Fábio");
        assertEquals("Fábio",page.obterNome());
    }

    @Test
    public void deveSelecionarCombo(){
        menu.acessarFormulario();
        page.selecionarCombo("Nintendo Switch");
        assertEquals("Nintendo Switch",page.obterValorCombo());
    }

    @Test
    public void deveInteragirComSwitchCheckBox(){
        menu.acessarFormulario();
        Assert.assertFalse(page.isCheckMarcado());
        Assert.assertTrue(page.isSwithMarcado());
        page.clicarCheck();
        page.clicarSwitch();
        Assert.assertTrue(page.isCheckMarcado());
        Assert.assertFalse(page.isSwithMarcado());
    }

    @Test
    public void preencherUmRegistro(){
        menu.acessarFormulario();
        page.escreverNome("Fábio");
        page.selecionarCombo("Nintendo Switch");
        page.clicarCheck();
        page.clicarSwitch();
        page.salvar();
        page.validarTexto(By.xpath("//android.widget.TextView[@text='Nome: Fábio']"), "Nome: Fábio");
        page.validarTexto(By.xpath("//android.widget.TextView[@text='Console: switch']"), "Console: switch");
        page.validarTexto(By.xpath("//android.widget.TextView[@text='Switch: Off']"), "Switch: Off");
        page.validarTexto(By.xpath("//android.widget.TextView[@text='Checkbox: Marcado']"), "Checkbox: Marcado");

    }

    @Test
    public void preencherUmRegistroDemorado(){
        menu.acessarFormulario();
        page.escreverNome("Fábio");
        page.salvarDemorado();
//        esperar(3000);
        WebDriverWait wait = new WebDriverWait(DriveFactory.getDriver(),10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Nome: Fábio']")));
        page.validarTexto(By.xpath("//android.widget.TextView[@text='Nome: Fábio']"), "Nome: Fábio");

    }

    @Test
    public void deveAlterarData(){
        menu.acessarFormulario();
        page.clicarPorTexto("01/01/2000");
        page.clicarPorTexto("20");
        page.clicarPorTexto("OK");
        Assert.assertTrue(page.existeElementoPorTexto("20/01/2000"));
    }

    @Test
    public void deveAlterarHora(){
        menu.acessarFormulario();
        page.clicarPorTexto("09:00");
        page.clicar(MobileBy.AccessibilityId("10"));
        page.clicar(MobileBy.AccessibilityId("40"));
        page.clicarPorTexto("OK");
        Assert.assertTrue(page.existeElementoPorTexto("10:40"));
    }

    @Test
    public void deveInteragirComSeekbar(){
     menu.acessarFormulario();
     page.clicarSeekBar(0.50,0.02);
     page.salvar();
    }

}


