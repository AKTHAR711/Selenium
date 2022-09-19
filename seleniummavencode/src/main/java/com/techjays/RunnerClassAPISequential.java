package com.techjays;

//import ...

@CucumberOptions(
                    strict = true,
                    plugin = {"pol.bde.utils.reporting.adapter.ExtentCucumberAdapter:"},
                    features = {"classpath:features"},
                    glue = {"pol.bde.steps", "pol.bde.hooks"}
)

/**
* Test Runner CLass for API Testing, extends the cucumber TestNG runner will sequential execution
*/
public class RunnerClassAPISequential extends AbstractTestNGCucumberTests {

        @AfterSuite
         public void teardown() {
                    TextReport tr = new TextReport();
                     tr.createReport(saveReport: true);
         }
}
