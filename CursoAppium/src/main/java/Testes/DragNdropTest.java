package Testes;

import Pages.DragNDropPage;
import Pages.MenuPage;
import appiumCourse.BaseTest;
import org.junit.Assert;
import org.junit.Test;

public class DragNdropTest extends BaseTest {

    private MenuPage menu = new MenuPage();
    private DragNDropPage page = new DragNDropPage();
    private String[] estadoInicial = new String[]{"Esta", "é uma lista", "Drag em Drop!", "Faça um clique longo,", "e arraste para", "qualquer local desejado."};
    private String[] estadoIntermediario = new String[]{"é uma lista", "Drag em Drop!", "Faça um clique longo,", "e arraste para","Esta", "qualquer local desejado."};

    private String[] estadoFinal = new String[]{ "Faça um clique longo,","é uma lista", "Drag em Drop!", "e arraste para","Esta", "qualquer local desejado."};
    @Test
    public void deveEfetuarDragNDrop(){
        menu.acessarDragNDrop();
        esperar(1000);
        Assert.assertEquals(estadoInicial,page.obterLista());
        page.arrastar("Esta","e arraste para");
        Assert.assertEquals(estadoIntermediario,page.obterLista());
        page.arrastar("Faça um clique longo,","é uma lista");
        Assert.assertEquals(estadoFinal,page.obterLista());
    }
}
