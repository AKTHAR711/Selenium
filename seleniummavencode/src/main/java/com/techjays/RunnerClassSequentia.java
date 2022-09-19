package com.techjays;

@cucumberoptions(
         strict = true,
         glue = {"pol.bde"}
)
/**
*The runner class to includes the drive stock with the scenario in test
*insted of extending io. cucumber. testing.AbstractTestNGcucumber annotation is used to include the browser
*details for the scenario found in the features as separated test
*
*Extending this class will run the test sequently
*/
@API(status = API.Status.STABLE)
Public class RunnerclassSequential extends BaseTest {

       Private TestNGCucucumberRunner testNGCucumberRunner;
       @BeforeClass(alwaysRun = true)
       public void setUp class(){testNGCucumberRunner = new TestNGCucumberRunner(this.getclass());}

       @Test(group = "cucumber", description = Runs  cucumber scenarios, dataprovider = "scenarios")
       Public void runscenario(pickleEventWrapper Piclewrapper cucumberFeaturewrapper featurewrapper map<string,string>map)  throws Throwable {
          //the 'featureWrapper' parameter solely exists to display the feature file in a test report
         //the 'map' parameter is for setting the driver context
           testNGCucumberRunner.runScenario(piclewrapper.getpickleEvent());

}

/**
 *Returns two dimensional array of PickleEventWrapper scenario with their associated CucumberFeatureWrapper feature
 *and required browser driver stock for the test execution
 *The two object is combined here and used furture Each senario has its browser detais
 *@return a two dimentional array of scenarios feature
*/
@DataProvider(name = "scenarios")
Public object [][] scenario() {
              //List of scenarios()
 object[][] x = dpscenario();

//browser driver stack
JSONArray jasonArr = dpDriverStackJason();

//creating object with scenario and browser stack combination

object[][] obj = new object[x.length * jsonArr.length()][3];
Gason gson = new GsonBuilder().create();

int k = 0;


for (int i = 0; i < jasonArr.length(); i++) {
    Jasonobject jasonobj = jasonArr.getJASONObject(i);
    /unchecked/
    Map<String, String > map = gson.fromJason(jasonobj.tostring(),Map.class);
    for (int i = 0; i < X.length; i++) {
        obj[k][0] = x[i][0];
        obj[k][1] = x[i][1];
        obj[k][2] = x[i][1];
        K++;
      }
   }
   return obj;
 }
 @Afterclass(alwaysRun = true)
 public void tearDownClass() {
     if(testNGCucumberRunner == null) {
         returns;
     }
     testNGCucumberRunner.finish();
  }
/**
 *return the scenarios
 *@return list of scenario
 */
 Public Object[][] dpscenario() {
     if(testNGCucumberRunner == null) {
        return new object[0][0];
  }
/**
 *returns the driver stock jason array
 *@return driver stock
*/

 Public JASONArray dpDriverStackJson() {
        log.debug ("spinningup up sequential exection");
        return JsoHelper.getJSONArray(propertyHelper.getVariable(propname:"driverStack") ! = null
               ? constants.DRIVERSTACKSPATH + PropertHelper.getvariable(proname"driverStack") + ".json"
               : Constants .DRIVERSTACKSPATH +PropertyHelper.getDefultProperty(key"driverstack") +".json"

  }
}

