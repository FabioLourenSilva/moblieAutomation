package Pages;

import appiumCourse.BasePage;
import org.openqa.selenium.By;

public class AccordionPage extends BasePage {

    public void selecionarOpcaoUm(){
        clicarPorTexto("Opção 1");
    }

    public String obterValorOp1(){
        return obterTexto(By.xpath("//*[@text='Esta é a descrição da opção 1']"));
    }
}
