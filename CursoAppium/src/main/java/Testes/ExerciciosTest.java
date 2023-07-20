package Testes;

import Pages.FormularioPage;
import Pages.MenuPage;
import Pages.SplashPage;
import appiumCourse.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;


public class ExerciciosTest extends BaseTest {

    MenuPage menu = new MenuPage();
    FormularioPage form = new FormularioPage();
    SplashPage splash = new SplashPage();

    @Test
    public void novoCadastro(){
     menu.acessarFormulario();
     form.escreverNome("Fábio Lourenço");
     form.selecionarCombo("PS4");
     form.clicarCheck();
     form.salvar();
        Assert.assertTrue(form.isCheckMarcado());
        form.validarTexto(By.xpath("//*[@text='Hora: 09:00']"),"Hora: 09:00");

    }
}
