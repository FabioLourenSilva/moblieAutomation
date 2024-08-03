package Pages;

import Base.BasePage;
import Base.BaseTest;
import Runner.RunTimMais;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class LoginTimMaisPage extends BasePage {

    BaseTest base = new BaseTest();
    static String soRunner;
    static String msisdnInput;
    static String passwordInput;

    static {
        RunTimMais runTimMais = new RunTimMais();
        soRunner = runTimMais.getSo();
        if (soRunner.equals("android")) {
            msisdnInput = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.EditText";
        } else {
            msisdnInput = "//XCUIElementTypeApplication[@name=\"TIM MAIS DEV\"]/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[3]/XCUIElementTypeOther[2]/XCUIElementTypeTextField";
        }
    }

    static {
        RunTimMais runTimMais = new RunTimMais();
        soRunner = runTimMais.getSo();
        if (soRunner.equals("android")) {
            passwordInput = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.EditText";
        } else {
            passwordInput = "Senha app Meu TIM";
        }
    }


    By continuarButton = By.xpath("//android.widget.Button[@content-desc=\"Continuar\"]");
    String pularOnboarding = "Pular";
    String pularTutorial = "Pular";
    By manterMe = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.CheckBox");

    By entrar = By.xpath("//android.widget.Button[@content-desc=\"Entrar\"]");

    String accessibilityStarUse = "Começar a usar";

    String acessibilityGoIntoTimMais = "Entrar no TIM MAIS";

    String accessibilityContinue = "Continuar";


    // LOGIN TIM MAIS SSO ATRIBUTOS


    public String getStartNow() {
        return startNow;
    }
    String startNow = "Começar agora";

    public String getLoadScreenPermission() {
        return loadScreenPermission;
    }

    String loadScreenPermission = "//*[@text='Geolocalização']";


    public String getPermission() {
        return permission;
    }

    String permission = "//*[@text='Permitir']";

    public String getGoBack() {
        return goBack;
    }

    String goBack = "Navegar";

    public String getAcessOtherNumber() {
        return acessOtherNumber;
    }

    String acessOtherNumber = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.Button[2]\n";


    public String getInsertMsisdn() {
        return insertMsisdn;
    }
    String insertMsisdn = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.EditText[1]";

    public String getPass() {
        return pass;
    }

    String pass = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.EditText[2]";

    public String getEnter() {
        return Enter;
    }

    String Enter = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.Button";

    public String getCheckBoxTerms() {
        return checkBoxTerms;
    }

    public String getConfirmTerms() {
        return confirmTerms;
    }

    String checkBoxTerms = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.CheckBox";

   String confirmTerms = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.Button";


    public String getCloseOnboarding() {
        return closeOnboarding;
    }

    public String getPermissionUseApp() {
        return permissionUseApp;
    }

    public String getPermissonLocal() {
        return permissonLocal;
    }

    String permissonLocal = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Button";

    String permissionUseApp = "//*[@text='Permitir durante o uso do app']";
    String closeOnboarding = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ImageView[1]";

    public String getCancelEmail() {
        return cancelEmail;
    }

    String cancelEmail = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.Button";

    public String getPermissionAllTime() {
        return permissionAllTime;
    }

    String permissionAllTime = "//*[@text='Permitir o tempo todo']";

    public String getMenu() {
        return menu;
    }

    String menu = "//android.widget.FrameLayout[@content-desc=\"Menu\"]/android.widget.FrameLayout/android.widget.ImageView";

    public String getTimADS() {
        return timADS;
    }

    String timADS = "//*[@text='PERMITIR']";

    public String getMenuTimMais() {
        return menuTimMais;
    }

    String menuTimMais = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[12]/android.view.ViewGroup";

    public String getPreTimMais() {
        return preTimMais;
    }

    String preTimMais = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Button";


    public String getTitleWelcome() {
        return titleWelcome;
    }

    String titleWelcome = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.app.Dialog/android.view.View/android.widget.TextView[1]";


    public String getLeaveTutorial() {
        return leaveTutorial;
    }

    public String getCanvas() {
        return canvas;
    }

    public String getWhitePage() {
        return whitePage;
    }

    String whitePage = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView";

    String canvas = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.widget.TextView";

    String leaveTutorial = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.app.Dialog/android.view.View/android.widget.Button[2]";

    public String getWait() {
        return wait;
    }

    String wait = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.widget.TextView[1]";

    public String getTutorialScreen() {
        return tutorialScreen;
    }

    String tutorialScreen = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.widget.TextView";

    public String getPularButton() {
        return pularButton;
    }

    String pularButton = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.app.Dialog/android.view.View";

    public String getAccessibilityContinue() {
        return accessibilityContinue;
    }

    public String getAccessibilityStarUse() {
        return accessibilityStarUse;
    }

    public String getAcessibilityGoIntoTimMais() {
        return acessibilityGoIntoTimMais;
    }


    public void addMsisdn(String msisdn) {
        clicarId(By.xpath(getInsertMsisdn()));
        escrever(By.xpath(getInsertMsisdn()), msisdn);
//        escrever(By.xpath(msisdnInput), msisdn);
//        doubleCheckWrite(msisdnInput,msisdn);
    }

    public void continuarButton() {
        clicar(continuarButton);
    }

    public void inserirSenha() throws InterruptedException {
        if (soRunner.equals("iOS")) {
            clicarId((MobileBy) MobileBy.AccessibilityId(passwordInput));
            escrever((MobileBy) MobileBy.AccessibilityId(passwordInput), "1234");
//        clicar(manterMe);
        } else {
            clicarId(By.xpath(passwordInput));
            escrever(By.xpath(passwordInput), "1234");
        }
    }

    public void welcomeHome() throws InterruptedException {
        if (existeElementoPorId("Pular")) {
            clicarId(MobileBy.AccessibilityId(pularOnboarding));
        }
        if (existeElementoPorId("Pular")) {
            clicarId(MobileBy.AccessibilityId(pularTutorial));
        }
            existeElementoPorId("+Vantagens");
    }





 }



