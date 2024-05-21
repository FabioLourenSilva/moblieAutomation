package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "/Users/fabiolourenco/Documents/Automation/TimMais/TimMaisMobileAutomation/src/main/java/Features/LoginTimMais.feature",
        glue = "Steps",
        tags = "@regressivo",
//        dryRun = true,
        plugin = {"pretty", "html:/Users/fabiolourenco/Documents/Automation/TimMais/TimMaisMobileAutomation/src/main/java/evidencias/evidenciaTimMais-ios-13-05v2.html"}
)

public class RunTimMais {
    String so =
            "android"
//            "iOS"
    ;
    public String getSo() {
        return so;
    }
}
