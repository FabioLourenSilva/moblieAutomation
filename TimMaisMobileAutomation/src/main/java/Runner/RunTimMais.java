package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "/Users/fabiolourenco/Documents/Automation/TimMais/TimMaisMobileAutomation/src/main/java/Features/LoginTimMais.feature",
        glue = "Steps",
        tags = "@TEST1",
//        dryRun = true,
        plugin = {"pretty", "html:/Users/fabiolourenco/Documents/Automation/TimMais/TimMaisMobileAutomation/src/main/java/evidencias/evidenciaTimMais-30-03.html"}
)

public class RunTimMais {

}
