package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
(features="src/test/java/features/SalesforceLogin.feature",
glue="StepDef",
monochrome=true,
publish=true)

public class SalesforceRunner extends AbstractTestNGCucumberTests
{

}
