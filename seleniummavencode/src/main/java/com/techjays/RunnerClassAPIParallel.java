package com.techjays;
//import ...
@CucumberOptions(
                    strict = true,
                    plugin = {"pol.bde.utils.reporting.adapter.ExtentCucumberAdapter:"},
                    features = {"classpath:features"},
                    glue = {"pol.bde.steps", "pol.bde.hooks"}
)

/**
*Runs each cucumber scenario found in the features as separated test
*/
@API(status = API.Status.STABLE)
public abstract class RunnerClassAPIParallel extends AbstractTestNGCucumberTests {
      /**
      * Returns two dimensional array of PickleEventWrapper scenarios
      * with their associated CucumberFeaturesWrapper feartures.
      *Executes the test in parallel.
      *@return a two dimensional array of scenarios features.
      */
      @Override
      @DataProvider(parallel = true)
      public Object[][] scenarios() { return super.scenarios(); }

      @AfterSuite
      public void teardown() {
         TextReport tr = new TextReport();
         tr.createReport(saveReport: true);
      }
}
