package Testes;

import Pages.MenuPage;
import Pages.ZonaAzulPage;
import appiumCourse.BaseTest;
import org.junit.Assert;
import org.junit.Test;

public class ZonaAzulTest extends BaseTest {
    private ZonaAzulPage page = new ZonaAzulPage();


    @Test
    public void deveAbriAPPzonaAzual(){
        esperar(1000);
        Assert.assertTrue(page.existeElementoPorTexto("CPF ou CNPJ"));
    }

    @Test
    public void deveEfetuarLogin(){
        esperar(1500);
        page.digitarSenha("cj5r3v6a");
        page.entrar();
        Assert.assertEquals("CPF/CNPJ informado não é válido.", page.obterTextoPOPup());
        page.confirmarPOPupCPFvazio();
    }



}
