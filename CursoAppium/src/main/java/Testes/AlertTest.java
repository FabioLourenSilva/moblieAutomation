package Testes;

import Pages.AlertaPage;
import Pages.MenuPage;
import appiumCourse.BaseTest;
import org.junit.Assert;
import org.junit.Test;

public class AlertTest extends BaseTest {

    private MenuPage menu = new MenuPage();
    private AlertaPage page = new AlertaPage();

    @Test
    public void deveConfirmarAlerta(){
        //deve acessar menu alerta
        menu.acessarAlertas();
        //deve clicar em elert confirme
        page.clicarEmAlertaConfirm();

        //deve verificar os texto
        Assert.assertEquals("Info",page.obterTituloAlerta());
        Assert.assertEquals("Confirma a operação?", page.obterMensagemAlerta());
        //deve confirmar o alterta
        page.confirmar();
        //verificar nova mensagem
        Assert.assertEquals("Info",page.obterTituloAlerta());
        Assert.assertEquals("Confirmado", page.obterMensagemAlerta());
        //sair
        page.sair();
    }

    @Test
    public void deveClicarForaAlerta(){
        menu.acessarAlertas();
        page.clicarAlertaSimples();
        esperar(1000);
        page.clicarForaCaixaAlerta();
        Assert.assertFalse(page.existeElementoPorTexto("Pode clicar no OK ou fora da caixa para sair"));
    }
}
