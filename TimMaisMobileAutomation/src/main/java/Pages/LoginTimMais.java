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


    public void addMsisdn(){
        clicar(msisdnInput);
        escrever(msisdnInput, "11140000513");
    }

    public void continuarButton(){
        clicar(continuarButton);
    }

    public void inserirMsisdn(){
        clicar(passwordInput);
        escrever(passwordInput, "0000");
        clicar(manterMe);
    }

    public void welcomeHome() throws InterruptedException {
        clicar(pularOnboarding);
        Thread.sleep(500);
        clicar(pularTutorial);
//        vaidarConteudoChar(destaques,"Destaques");
        Thread.sleep(2000);
    }


}
