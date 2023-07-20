package appiumCourse;

import Pages.MenuPage;
import appiumCourse.DriveFactory;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class BaseTest {

    private MenuPage menuPage = new MenuPage();

    @Rule
    public TestName testName = new TestName();


    @AfterClass
    public static void finalizaClasse(){
        DriveFactory.killDriver();
    }

//    @Before
//    public void acessoAPP(){
//        esperar(1000);
//        menuPage.clicarPorTexto("Continuar");
//        esperar(1000);
//        menuPage.clicarPorTexto("OK");
//    }
    @After
    public void tearDown(){
        gerarScreenShot();
        DriveFactory.getDriver().resetApp();
    }

    public void gerarScreenShot()  {
      try {
          File imagem = ((TakesScreenshot) DriveFactory.getDriver()).getScreenshotAs(OutputType.FILE);
          FileUtils.copyFile(imagem, new File("target/screenshots/"+testName.getMethodName()+".png"));
      } catch (IOException e){
          e.printStackTrace();
      }
    }

    public void esperar(long tempo){
        try {
            Thread.sleep(tempo);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
