package Testes;

import Pages.AbasPage;
import Pages.MenuPage;
import appiumCourse.BaseTest;
import org.junit.Assert;
import org.junit.Test;

public class AbasTest extends BaseTest {

    private MenuPage menu = new MenuPage();
    private AbasPage aba = new AbasPage();
    @Test
    public void deveInteragirComAbas(){

        menu.acessarAbas();
        Assert.assertEquals("Este é o conteúdo da Aba 1",aba.verificarAbaUm());
        aba.selecionarAbaDois();
        Assert.assertEquals("Este é o conteúdo da Aba 2",aba.verificarAbaDois());
    }

}
