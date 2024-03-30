package Steps;

import Base.BasePage;
import Pages.LoginTimMais;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

public class LoginTimMaisStepDefinitions extends BasePage {

    LoginTimMais login = new LoginTimMais();

    @Given("acesso o app TIM MAIS e clico no botao comecar a usar")
    public void acesso_o_app_tim_mais() {
        clicar(By.xpath("//android.view.View[@content-desc=\"Começar a usar\"]"));
        boolean allow = existeElementoPorTexto("Allow");

        if (allow) {
            clicarPorTexto("Allow");
        }

    }

    @When("clico no botao Entrar no TIM MAIS")
    public void clico_no_botao() {
        clicar(By.xpath("//android.widget.Button[@content-desc=\"Entrar no TIM MAIS\"]"));
    }

    @When("insiro o msisdn")
    public void insiro_o_msisdn() {
        login.addMsisdn();
    }


    @When("clico no botao continuar")
    public void clico_no_botao_continuar() {
        login.continuarButton();
    }

    @When("insiro a senha")
    public void insiro_a_senha() {
        login.inserirMsisdn();
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