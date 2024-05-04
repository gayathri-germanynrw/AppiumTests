package com.cydeo.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/cucumber-reports.html"
        },
        features = "C:\\Users\\gayat\\IdeaProjects\\AppiumTests\\src\\test\\resources\\feature",
        glue = "com/cydeo/step_definitions",
        dryRun = false,
        //tags = "@SwagLabLogin"
        //tags="@cloudWebAppTest"
        tags="@remoteAndroid"
        //tags="@wip"

)
public class CukesRunner {
}