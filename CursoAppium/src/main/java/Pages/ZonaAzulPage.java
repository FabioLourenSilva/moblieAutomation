package Pages;

import appiumCourse.BasePage;
import appiumCourse.DriveFactory;
import org.openqa.selenium.By;

public class ZonaAzulPage extends BasePage {
    public void digitarUsuario(String CPF_CNPJ){
        DriveFactory.getDriver().findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.widget.EditText")).click();
        escrever(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.widget.EditText"),CPF_CNPJ);
    }
    public void digitarSenha(String senha){
        escrever(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.view.View/android.view.View/android.view.View/android.widget.EditText"),senha);
    }
    public void entrar(){
        clicarPorTexto("ENTRAR");
    }
    public String obterTextoPOPup(){
       return obterTexto(By.xpath("//android.widget.TextView[@text='CPF/CNPJ informado não é válido.']"));
    }
    public void confirmarPOPupCPFvazio(){
        clicarPorTexto("OK");
    }
}
