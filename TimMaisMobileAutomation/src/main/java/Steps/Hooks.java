package Steps;

import Base.DriveFactory;
import io.cucumber.java.AfterStep;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks extends DriveFactory {
    @AfterStep
    public void takeScreenshot(Scenario scenario) {
//        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
//        }
    }

    @After
    public void tearDown(){
        DriveFactory.killDriver();
    }
}
