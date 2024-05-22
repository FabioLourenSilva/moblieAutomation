package Steps;

import Base.BasePage;
import Base.BaseTest;
import Base.DriveFactory;
import Pages.LoginTimMais;
import Runner.RunTimMais;
import io.appium.java_client.MobileBy;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class LoginTimMaisStepDefinitions extends BasePage {

    LoginTimMais login = new LoginTimMais();
    BaseTest base = new BaseTest();
    DriveFactory drive = new DriveFactory();


    @Given("acesso o app TIM MAIS e clico no botao comecar a usar")
    public void acesso_o_app_tim_mais() throws InterruptedException {

        boolean startUse = existeElementoPorId("Começar a usar");
        if (startUse) {
            clicarId(MobileBy.AccessibilityId("Começar a usar"));
        }

        boolean allow = existeElementoPorTexto("Allow");
        if (allow) {
            clicarPorTexto("Allow");
        }
    }

    @When("clico no botao Entrar no TIM MAIS")
    public void clico_no_botao() {
        clicarId((MobileBy) MobileBy.AccessibilityId("Entrar no TIM MAIS"));
    }

    @When("insiro o msisdn {string}")
    public void insiro_o_msisdn(String msisdn) {
        base.esperar(600);
        login.addMsisdn(msisdn);
    }

    @When("clico no botao continuar")
    public void clico_no_botao_continuar() {
        clicarId(MobileBy.AccessibilityId("Continuar"));
    }

    @When("insiro a senha")
    public void insiro_a_senha() {
        login.inserirSenha();
    }

    @When("clico no botão continuar senha")
    public void clico_no_botão_continuar_senha() {
        clicarEntrar();
    }

    @Then("visualizo home")
    public void visualizo_home() throws InterruptedException {
        login.welcomeHome();

    }

}