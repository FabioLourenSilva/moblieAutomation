package Testes;

import Pages.AccordionPage;
import Pages.MenuPage;
import appiumCourse.BaseTest;
import org.junit.Assert;
import org.junit.Test;

public class AccordionTest extends BaseTest {

    private MenuPage menu = new MenuPage();
    private AccordionPage page = new AccordionPage();

    @Test
    public void deveInteragirComAccordion(){
        menu.acessarAccordion();
        page.selecionarOpcaoUm();
        Assert.assertEquals("Esta é a descrição da opção 1", page.obterValorOp1());
    }
}
