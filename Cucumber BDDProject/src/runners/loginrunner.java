package runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="Project_Feature",
glue="stepDefinition",
tags= {"@endtoend","@regularexpression"}
)

public class loginrunner {

}
