package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;

@CucumberOptions(
		features= {"src/test/java/features"},
		dryRun =!true,
		snippets = SnippetType.CAMELCASE
		,monochrome = true
		,glue={"steps","Hooks"}//connects with steps
		,plugin= {"pretty","html:Cucumber"}//report
        ,tags = "@cleancart" 
		)

public class Runner extends AbstractTestNGCucumberTests 
{

	
	
	
}
