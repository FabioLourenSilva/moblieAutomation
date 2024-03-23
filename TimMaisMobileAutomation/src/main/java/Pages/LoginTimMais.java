package Pages;

import Base.BasePage;
import org.openqa.selenium.By;

public class LoginTimMais extends BasePage {

    By msisdnInput = By.xpath("/hierarchy/android.widget.FrameLayout" +
            "/android.widget.LinearLayout/android.widget.FrameLayout/android.widget." +
            "FrameLayout/android.view.View/android.view.View/android.view.View/android." +
            "view.View/android.view.View[2]/android.view.View/android.widget.EditText");
    By continuarButton = By.xpath("//android.widget.Button[@content-desc=\"Continuar\"]");
    By passwordInput = By.xpath("/hierarchy/android.widget.FrameLayout/android." +
            "widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view" +
            ".View/android.view.View/android.view.View/android.view.View/android.view.View[2]/" +
            "android.view.View/android.widget.EditText");
    By pularOnboarding = By.xpath("//android.widget.Button[@content-desc=\"Pular\"]");
    By pularTutorial = By.xpath("//android.widget.Button[@content-desc=\"Pular\"]");
    By destaques = By.xpath("//android.view.View[@content-desc=\"Destaques\"]");
    By manterMe = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.CheckBox");

    String id = "00000000-0000-0029-0000-003100000003";
    By entrar = By.xpath("//android.widget.Button[@content-desc=\"Entrar\"]");


    public void loginInApp() throws InterruptedException {
        clicar(By.xpath("//android.view.View[@content-desc=\"Começar a usar\"]"));
        boolean allow = existeElementoPorTexto("Allow");

        if (allow){
            clicarPorTexto("Allow");
        }

        clicar(By.xpath("//android.widget.Button[@content-desc=\"Entrar no TIM MAIS\"]"));
        clicar(msisdnInput);
        escrever(msisdnInput, "34991466160");
        clicar(continuarButton);
        clicar(passwordInput);
        escrever(passwordInput, "0000");
        clicar(manterMe);
        clicarEntrar();
        clicar(pularOnboarding);
        Thread.sleep(500);
        clicar(pularTutorial);
        vaidarConteudoChar(destaques,"Destaques");
        Thread.sleep(2000);
    }


}
