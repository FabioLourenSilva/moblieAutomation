package Pages;

import Base.BasePage;
import Base.BaseTest;
import Runner.RunTimMais;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class LoginTimMais extends BasePage {

    BaseTest base = new BaseTest();


    static String soRunner;
    static String msisdnInput;
    static String passwordInput;

    static {
        RunTimMais runTimMais = new RunTimMais();
        soRunner = runTimMais.getSo();
        if (soRunner.equals("android")){
            msisdnInput = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.EditText";
        }
        else {
            msisdnInput = "//XCUIElementTypeApplication[@name=\"TIM MAIS DEV\"]/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[3]/XCUIElementTypeOther[2]/XCUIElementTypeTextField";
        }
    }

    static {
        RunTimMais runTimMais = new RunTimMais();
        soRunner = runTimMais.getSo();
        if (soRunner.equals("android")){
            passwordInput = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.EditText";
        }
        else {
            passwordInput = "//XCUIElementTypeSecureTextField[@name=\"Senha app Meu TIM";
        }
    }



    By continuarButton = By.xpath("//android.widget.Button[@content-desc=\"Continuar\"]");

    By pularOnboarding = By.xpath("//android.widget.Button[@content-desc=\"Pular\"]");
    By pularTutorial = By.xpath("//android.widget.Button[@content-desc=\"Pular\"]");

    By manterMe = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.CheckBox");

    By entrar = By.xpath("//android.widget.Button[@content-desc=\"Entrar\"]");


    public void addMsisdn(String msisdn){
        clicarId(By.xpath(msisdnInput));
        escrever(By.xpath(msisdnInput),msisdn);

    }

    public void continuarButton(){
        clicar(continuarButton);
    }

    public void inserirSenha(){
//        clicarId((MobileBy) MobileBy.AccessibilityId(passwordInput));
//        escreverId((MobileBy) MobileBy.AccessibilityId(passwordInput),"0000");
//        clicar(manterMe);
        clicar(By.xpath(passwordInput));
        escrever(By.xpath(passwordInput),"0000");
    }

    public void welcomeHome() throws InterruptedException {
        Thread.sleep(1500);
        clicar(pularOnboarding);
        Thread.sleep(300);
        clicar(pularTutorial);
        base.esperar(1500);
//        validarConteudoID("Destaques","D e s t a q u e s");
    }


}
