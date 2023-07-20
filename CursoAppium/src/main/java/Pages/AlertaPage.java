package Pages;

import appiumCourse.BasePage;
import org.openqa.selenium.By;

public class AlertaPage extends BasePage {

    public void clicarEmAlertaConfirm(){
        clicarPorTexto("ALERTA CONFIRM");
    }


    public void confirmar(){
        clicarPorTexto("CONFIRMAR");
    }
    public void sair(){
        clicarPorTexto("SAIR");
    }

    public void clicarAlertaSimples(){
        clicarPorTexto("ALERTA SIMPLES");
    }

    public void clicarForaCaixaAlerta(){
        tap(140,111);
    }

}
