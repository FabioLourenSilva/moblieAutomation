package Testes;

import Pages.LoginTimMais;
import Base.BaseTest;
import org.junit.Test;

public class TimMaisTest extends BaseTest {
    LoginTimMais login = new LoginTimMais();

    @Test
    public void deveLogarTimMais() throws InterruptedException {
    login.loginInApp();
    }

}
