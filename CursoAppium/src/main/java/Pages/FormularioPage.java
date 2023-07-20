package Pages;

import appiumCourse.BasePage;
import appiumCourse.DriveFactory;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import static appiumCourse.DriveFactory.*;

public class FormularioPage extends BasePage {

    public void escreverNome(String nome){
        escrever(MobileBy.AccessibilityId("nome"),nome);
    }

    public String obterNome(){
        return obterTexto(MobileBy.AccessibilityId("nome"));
    }

    public void selecionarCombo(String valor){
        selecionarCombo(MobileBy.AccessibilityId("console"),valor);
    }

    public String obterValorCombo(){
        return obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView"));
    }

    public void clicarCheck(){
        clicar(By.className("android.widget.CheckBox"));
    }

    public void clicarSwitch(){
        clicar(MobileBy.AccessibilityId("switch"));
    }

    public boolean isCheckMarcado(){
        return isCheckMarcado(By.className("android.widget.CheckBox"));
    }

    public boolean isSwithMarcado(){
        return isCheckMarcado(MobileBy.AccessibilityId("switch"));
    }

    public void clicarSeekBar(double posicao,double delta){

      MobileElement seek = getDriver().findElement(MobileBy.AccessibilityId("slid"));
      int y = seek.getLocation().y + (seek.getSize().height / 2);
        System.out.println(y);
      int x = (int) (seek.getLocation().x + (seek.getSize().width * (posicao+delta)));
        System.out.println(x);
      tap(x,y);
    }

    public void salvar(){
        clicarPorTexto("SALVAR");
    }

    public void salvarDemorado(){
        clicarPorTexto("SALVAR DEMORADO");
    }

    public void validarTexto(By by, String texto){
        vaidarConteudo(by, texto);
    }

}
