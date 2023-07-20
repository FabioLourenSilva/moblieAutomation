package Testes;

import Pages.MenuPage;
import Pages.WebViewPage;
import appiumCourse.BaseTest;
import org.junit.After;
import org.junit.Test;

public class WebViewTest extends BaseTest {

    private MenuPage menu = new MenuPage();
    private WebViewPage page = new WebViewPage();
    @Test
    public void deveFazerLogin(){
    menu.acessarSBhibrido();
    esperar(3000);
    page.entrarContextoWeb();
    page.setEmail("fabioloureno412@gmail.com");
    }

    @After
    public void tearDown(){
      page.sairContextoWeb();
    }
}
