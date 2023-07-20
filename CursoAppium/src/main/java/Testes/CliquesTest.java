package Testes;

import Pages.CliquesPage;
import Pages.MenuPage;
import appiumCourse.BaseTest;
import org.junit.Assert;
import org.junit.Test;

public class CliquesTest extends BaseTest {

    private MenuPage menu = new MenuPage();
    private CliquesPage cliquesPage = new CliquesPage();
    @Test
    public void deveRealizarCliqueLongo(){
        menu.acessarCliques();
        cliquesPage.cliqueLongo();
        Assert.assertEquals("Clique Longo",cliquesPage.obterTextoCampo());
    }

    @Test
    public void deveRealizarCliqueDuplo(){
        menu.acessarCliques();
        cliquesPage.cliqueDuplo();
        Assert.assertEquals("Duplo Clique",cliquesPage.obterTextoCampo());
    }

}
