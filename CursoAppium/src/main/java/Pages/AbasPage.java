package Pages;

import appiumCourse.BasePage;
import org.openqa.selenium.By;

public class AbasPage extends BasePage {

    public String verificarAbaUm(){
        return obterTexto(By.xpath("//*[@text='Este é o conteúdo da Aba 1']"));
    }
    public void selecionarAbaDois(){
        clicarPorTexto("Aba 2");
    }

    public String verificarAbaDois(){
        return obterTexto(By.xpath("//*[@text='Este é o conteúdo da Aba 2']"));
    }

}
