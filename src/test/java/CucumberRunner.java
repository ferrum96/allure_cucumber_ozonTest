import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = { "src/test/resources/features" },
        glue = {"ru.appline.autotests.steps"},
        tags = {"@scenario1 , @scenario2"}

)
public class CucumberRunner {
}
