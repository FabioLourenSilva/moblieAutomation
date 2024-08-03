package Steps;

import Base.BasePage;
import Pages.LoginTimMaisPage;
import Runner.RunTimMais;
import io.appium.java_client.MobileBy;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.utils.WebViewPage;
import static Base.DriveFactory.getDriver;


public class LoginTimMaisStepDefinitions extends BasePage {

    LoginTimMaisPage login = new LoginTimMaisPage();
    WebViewPage webViewPage = new WebViewPage();

    static String soRunner;
    static {
        RunTimMais runTimMais = new RunTimMais();
        soRunner = runTimMais.getSo();
    }



    @Given("acesso o app TIM MAIS e clico no botao comecar a usar")
    public void acesso_o_app_tim_mais() throws InterruptedException {
        if (soRunner.equals("android")) {
           webViewPage.entrarContextoWeb();
           Thread.sleep(10000);
            clicarPorTexto("Começar a usar");

        }
    }

    @When("clico no botao Entrar no TIM MAIS")
    public void clico_no_botao() {
        clicarId(MobileBy.AccessibilityId(login.getAcessibilityGoIntoTimMais()));
    }

    @When("insiro o msisdn {string}")
    public void insiro_o_msisdn(String msisdn) {
        waitElement(By.xpath(login.getInsertMsisdn()),10);
        login.addMsisdn(msisdn);
    }

    @When("clico no botao continuar")
    public void clico_no_botao_continuar() {
        clicarId(MobileBy.AccessibilityId(login.getAccessibilityContinue()));
    }

    @When("insiro a senha")
    public void insiro_a_senha() throws InterruptedException {
        waitElement(By.xpath(login.getPass()),5);
        escrever(By.xpath(login.getPass()),"6525");
    }

    @When("clico no botão continuar senha")
    public void clico_no_botão_continuar_senha() {
        clicarEntrar();
    }

    @Then("visualizo home")
    public void visualizo_home() throws InterruptedException {
        login.welcomeHome();
    }

// LOGIN MEU TIM SSO
    @Given("acesso o app MEU TIM")
    public void acesso_o_app_meu_tim() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(),60);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(login.getLoadScreenPermission())));
        scroll(0.9,0.1);
        clicarPorTexto(login.getStartNow());
    }

    @Given("aceito as permissoes")
    public void aceito_as_permissoes() {
        waitElement(By.xpath(login.getPermission()),10);
        clicarPorTexto("Permitir");
        waitElement(By.xpath(login.getPermission()),10);
        clicarPorTexto("Permitir");
        waitElement(new MobileBy.ByAccessibilityId(login.getGoBack()),10);
        clicar(new MobileBy.ByAccessibilityId(login.getGoBack()));

        String appPackage = "br.com.timbrasil.meutim";
        getDriver().activateApp(appPackage);
    }
    @Given("clico no botao acessar com outro numero")
    public void clico_no_botao_acessar_com_outro_numero() {
        waitElement(By.xpath(login.getAcessOtherNumber()),100);
       if (existeElementoPorXpath(login.getAcessOtherNumber())){
            clicar(By.xpath(login.getAcessOtherNumber()));
        }
    }
    @When("clico no botao entrar")
    public void clico_no_botao_entrar() {
        waitElement(By.xpath(login.getEnter()),2);
        clicar(By.xpath(login.getEnter()));
    }
    @When("li e aceito os termos e confirmo")
    public void li_e_aceito_os_termos_e_confirmo() {
        waitElement(By.xpath(login.getCheckBoxTerms()),120);
        clicar(By.xpath(login.getCheckBoxTerms()));
        waitElement(By.xpath(login.getConfirmTerms()),5);
        clicar(By.xpath(login.getConfirmTerms()));
    }
    @When("fecho o onboarding MEU TIM")
    public void fecho_o_onboarding_meu_tim() {
        waitElement(By.xpath(login.getCloseOnboarding()),60);
        clicar(By.xpath(login.getCloseOnboarding()));
    }
    @When("concedo permissoes")
    public void concedo_permissoes() {
        waitElement(By.xpath(login.getPermissionUseApp()),60);
        clicar(By.xpath(login.getPermissionUseApp()));

        boolean timADS = existeElementoPorXpath(login.getTimADS());

        if (timADS){
            clicar(By.xpath(login.getTimADS()));
        }

        boolean email = existeElementoPorXpath(login.getCancelEmail());

        if (email){
            clicar(By.xpath(login.getCancelEmail()));
        }

        waitElement(By.xpath(login.getPermissonLocal()),30);
        clicar(By.xpath(login.getPermissonLocal()));


        waitElement(By.xpath(login.getPermissionAllTime()),2);
        clicar(By.xpath(login.getPermissionAllTime()));
    }
    @When("clico no menu lateral")
    public void clico_no_menu_lateral() {
        waitElement(By.xpath(login.getMenu()),30);
        clicar(By.xpath(login.getMenu()));
    }
    @When("clico no menu TIM MAIS")
    public void clico_no_menu_tim_mais() {
        waitElement(By.xpath(login.getMenuTimMais()),60);
        clicar(By.xpath(login.getMenuTimMais()));

        boolean loadingButton = existeElementoPorTexto("Entendi") ;

        if (loadingButton) {
            waitElement(By.xpath(login.getPreTimMais()), 60);
            clicar(By.xpath(login.getPreTimMais()));
        }
    }
    @Then("visualizo o tutorial guiado")
    public void visualizo_o_tutorial_guiado() {
        webViewPage.switchToWebViewContext();
    }
    @Then("pulo o tutorial")
    public void pulo_o_tutorial() throws InterruptedException {




    }

}