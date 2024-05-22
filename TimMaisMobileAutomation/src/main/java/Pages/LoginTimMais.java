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
            passwordInput = "Senha app Meu TIM";
        }
        else {
            passwordInput = "Senha app Meu TIM";
        }
    }



    By continuarButton = By.xpath("//android.widget.Button[@content-desc=\"Continuar\"]");

    String pularOnboarding = "Pular";
    String pularTutorial = "Pular";

    By manterMe = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.CheckBox");

    By entrar = By.xpath("//android.widget.Button[@content-desc=\"Entrar\"]");


    public void addMsisdn(String msisdn){
        clicarId(By.xpath(msisdnInput));
        escreverChar(By.xpath(msisdnInput),msisdn);
    }

    public void continuarButton(){
        clicar(continuarButton);
    }

    public void inserirSenha() throws InterruptedException {
        clicarId((MobileBy) MobileBy.AccessibilityId(passwordInput));
        escrever((MobileBy) MobileBy.AccessibilityId(passwordInput),"1234");
//        clicar(manterMe);

    }

    public void welcomeHome() throws InterruptedException {
        if (existeElementoPorId("Pular")){
            clicarId(MobileBy.AccessibilityId(pularOnboarding));
        }
        if (existeElementoPorId("Pular")){
            clicarId(MobileBy.AccessibilityId(pularTutorial));
        }
        validarConteudoID("+Vantagens","+Vantagens");
    }


}
