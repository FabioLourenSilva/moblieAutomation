package Testes;

import Pages.MenuPage;
import Pages.SwipeListPage;
import appiumCourse.BaseTest;
import org.junit.Assert;
import org.junit.Test;

public class SwipeElementTest extends BaseTest {
    private MenuPage menu = new MenuPage();
    private SwipeListPage swipeList = new SwipeListPage();

    @Test
    public void deveResolverDesafio(){

      menu.acessarSwipList();
      swipeList.SwipeElementRight("Opção 1");
      swipeList.clicarBotaoMais();
      Assert.assertTrue(menu.existeElementoPorTexto("Opção 1 (+)"));
      swipeList.SwipeElementRight("Opção 4");
      menu.clicarPorTexto("(-)");
      Assert.assertTrue(menu.existeElementoPorTexto("Opção 4 (-)"));
      swipeList.SwipeElementLeft("Opção 5 (-)");
      esperar(1000);
      Assert.assertTrue(menu.existeElementoPorTexto("Opção 5"));
    }
}
