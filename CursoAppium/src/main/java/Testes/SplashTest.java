package Testes;

import Pages.MenuPage;
import Pages.SplashPage;
import appiumCourse.BaseTest;
import org.junit.Assert;
import org.junit.Test;

public class SplashTest extends BaseTest {

    private MenuPage menu = new MenuPage();
    private SplashPage page = new SplashPage();

    @Test
    public void deveAguardarSplashSumir(){

        //acessar menu splash
        menu.acessarSplash();
        //verificar que o splash esta sendo exibido
        page.isTelaSplashVisivel();
        //aguardar saida do splash
       page.aguardarSplashSumir();
        //verificar que o formulario esta aparecendo
        Assert.assertTrue(page.existeElementoPorTexto("Formulário"));
    }

}
