package Base;

import org.utils.MenuPage;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.rules.TestName;

public class BaseTest {

    private MenuPage menuPage = new MenuPage();

    @Rule
    public TestName testName = new TestName();

    @AfterClass
    public static void finalizaClasse(){
        DriveFactory.killDriver();
    }

    @After
    public void tearDown(){
//        DriveFactory.getDriver().resetApp();
        DriveFactory.killDriver();
    }

    public void esperar(long tempo){
        try {
            Thread.sleep(tempo);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
